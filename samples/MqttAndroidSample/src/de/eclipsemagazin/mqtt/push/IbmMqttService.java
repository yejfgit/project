package de.eclipsemagazin.mqtt.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.provider.Settings.Secure;
import android.util.Log;


 
import java.util.Locale;

import com.ibm.micro.client.mqttv3.MqttCallback;
import com.ibm.micro.client.mqttv3.MqttClient;
import com.ibm.micro.client.mqttv3.MqttDefaultFilePersistence;
import com.ibm.micro.client.mqttv3.MqttDeliveryToken;
import com.ibm.micro.client.mqttv3.MqttException;
import com.ibm.micro.client.mqttv3.MqttMessage;
import com.ibm.micro.client.mqttv3.MqttPersistenceException;
import com.ibm.micro.client.mqttv3.MqttTopic;
 
 
/**
 * ���ͷ���
 */
public class IbmMqttService extends Service implements MqttCallback {
    public static final String DEBUG_TAG = IbmMqttService.class.getName(); // Log���
    public static String            MQTT_CLIENT_ID = "Fangchao";
    private static final String MQTT_THREAD_NAME = ""; // Handler Thread ID
 
    private static final String MQTT_BROKER_TEST = "10.7.200.141"; //���Ե�ַ
    private static final String MQTT_BROKER_ONLINE = "mqtt.supumall.com"; //��ʽ��ַ
    private static final String MQTT_BROKER = MQTT_BROKER_TEST;
 
    private static final int MQTT_PORT = 1883;                // ���������Ͷ˿�
 
    public static final int MQTT_QOS_0 = 0; //��ϢͶ�ż��� QOS Level 0 (���һ�Σ��п����ظ���ʧ�� )
    public static final int MQTT_QOS_1 = 1; //��ϢͶ�ż��� QOS Level 1 (����һ�Σ��п����ظ��� )
    public static final int MQTT_QOS_2 = 2; //��ϢͶ�ż��� QOS Level 2 (ֻ��һ�Σ�ȷ����Ϣֻ����һ�Σ����ڱȽ��ϸ�ļƷ�ϵͳ����)
 
    public static final String[] topicFilters = {"TC_NEWORDER84"};//���ĵ�����
    public static int[] qos = {MQTT_QOS_0};//���ļ���
 
    private static final int MQTT_KEEP_ALIVE = 4 * 60 * 1000; //������ʱ�䣬����
    private static final String MQTT_KEEP_ALIVE_TOPIC_FORAMT = "/users/%s/keepalive"; // Topic format for KeepAlives
    private static final byte[] MQTT_KEEP_ALIVE_MESSAGE = {0}; // ��������������
    private static final int MQTT_KEEP_ALIVE_QOS = MQTT_QOS_0; //�������ķ��ͼ���Ĭ�����
 
    private static final boolean MQTT_CLEAN_SESSION = true; // Start a clean session?
 
    private static final String MQTT_URL_FORMAT = "tcp://%s:%d"; // ����url��ʽ��װ
 
    private static final String ACTION_START =MQTT_CLIENT_ID + ".START"; // Action to start ����
    private static final String ACTION_STOP = MQTT_CLIENT_ID + ".STOP"; // Action to stop ֹͣ
    private static final String ACTION_KEEPALIVE = MQTT_CLIENT_ID + ".KEEPALIVE"; // Action to keep alive used by alarm manager������������ʹ��
    private static final String ACTION_RECONNECT = MQTT_CLIENT_ID + ".RECONNECT"; // Action to reconnect ��������
 
 
    private static final String DEVICE_ID_FORMAT = "an_%s"; // �豸id��ǰ׺
    // Note:�豸id���Ƴ���Ϊ23�� �ַ�
    // An NPE if you go over that limit
    private boolean mStarted = false; //����client�Ƿ�����
    private String mDeviceId;          // Device ID, Secure.ANDROID_ID
    private Handler mConnHandler;      // Seperate Handler thread for networking
 
    private MqttDefaultFilePersistence mDataStore; // Defaults to FileStore
//    private MqttConnectOptions mOpts;            //���Ӳ���
 
    private MqttTopic mKeepAliveTopic;            // Instance Variable for Keepalive topic
 
    private MqttClient mClient;                    // Mqtt Client
 
    private AlarmManager mAlarmManager;            //����
    private ConnectivityManager mConnectivityManager; //����ı������
 
    /**
     * �������ͷ���
     *
     * @param ctx context to start the service with
     * @return void
     */
    public static void actionStart(Context ctx) {
        Intent i = new Intent(ctx, IbmMqttService.class);
        i.setAction(ACTION_START);
        ctx.startService(i);
    }
 
    /**
     * ֹͣ���ͷ���
     *
     * @param ctx context to start the service with
     * @return void
     */
    public static void actionStop(Context ctx) {
        Intent i = new Intent(ctx, IbmMqttService.class);
        i.setAction(ACTION_STOP);
        ctx.startService(i);
    }
 
    /**
     * ����������
     *
     * @param ctx context to start the service with
     * @return void
     */
    public static void actionKeepalive(Context ctx) {
        Intent i = new Intent(ctx, IbmMqttService.class);
        i.setAction(ACTION_KEEPALIVE);
        ctx.startService(i);
    }
 
    /**
     * Initalizes the DeviceId and most instance variables
     * Including the Connection Handler, Datastore, Alarm Manager
     * and ConnectivityManager.
     * ��ʼ���豸id����������������Ӵ������ݴ洢�����Ӿ��������������
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("fc","oncreate");
        //��ʼ���豸id�����Ȳ��ܳ���23
        mDeviceId = String.format(DEVICE_ID_FORMAT,
                Secure.getString(getContentResolver(), Secure.ANDROID_ID));
 
        HandlerThread thread = new HandlerThread(MQTT_THREAD_NAME);
        thread.start();
 
        mConnHandler = new Handler(thread.getLooper());
 
        try {
			mDataStore = new MqttDefaultFilePersistence(getCacheDir().getAbsolutePath());
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
 
//        mOpts = new MqttConnectOptions();
//        mOpts.setCleanSession(MQTT_CLEAN_SESSION);
        // Do not set keep alive interval on mOpts we keep track of it with alarm's
 
        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        mConnectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    }
 
    @Override
    public boolean isRestricted() {
        return super.isRestricted();
    }
 
    /**
     * Service onStartCommand
     * Handles the action passed via the Intent
     * ͨ����ͼ�������
     *
     * @return START_REDELIVER_INTENT
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
 
        String action = intent.getAction();
        Log.e(DEBUG_TAG, "���ͷ�����յ�һ������ " + action);
 
        if (action == null) {
            Log.e(DEBUG_TAG, "���ͷ�����յ�������Ϊnull�����ͷ���ִ���κβ���");
        } else {
            if (action.equals(ACTION_START)) {
                       Log.e(DEBUG_TAG, "���յ������������ͷ�������");
                start();
            } else if (action.equals(ACTION_STOP)) {
                       Log.e(DEBUG_TAG, "���յ���ֹͣ�����ͷ�������");
                stop();
            } else if (action.equals(ACTION_KEEPALIVE)) {
                       Log.e(DEBUG_TAG, "���յ������������������ͷ�������");
                keepAlive();
            } else if (action.equals(ACTION_RECONNECT)) {
                       Log.e(DEBUG_TAG, "���յ������������ͷ�������");
                if (isNetworkAvailable()) {
                    reconnectIfNecessary();
                }
            }
        }
 
        return START_REDELIVER_INTENT;
    }
 
    /**
     * �����������ͷ���������ע������ı������
     */
    private synchronized void start() {
        if (mStarted) {
                   Log.e(DEBUG_TAG, "�����������ͷ��񣬵����ͷ����Ѿ�����");
            return;
        }
 
        if (hasScheduledKeepAlives()) {
            stopKeepAlives();
        }
 
        connect();
 
        registerReceiver(mConnectivityReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }
 
    /**
     * ֹͣ���ͷ���
     */
    private synchronized void stop() {
        if (!mStarted) {
                   Log.e(DEBUG_TAG, "��ͼֹͣ���ͷ������������ͷ���û������");
            return;
        }
 
        if (mClient != null) {
            mConnHandler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        mClient.disconnect();
                    } catch (MqttException ex) {
                        ex.printStackTrace();
                    }
                    mClient = null;
                    mStarted = false;
 
                    stopKeepAlives();
                }
            });
        }
 
        unregisterReceiver(mConnectivityReceiver);
    }
 
    /**
     * Connects to the broker with the appropriate datastore
     * ���ӵ����ͷ��������ʵ������ݴ洢
     */
    private synchronized void connect() {
        String url = String.format(Locale.US, MQTT_URL_FORMAT, MQTT_BROKER, MQTT_PORT);
               Log.e(DEBUG_TAG, "�������ͷ����� �豸id�� "+ mDeviceId + " with URL: " + url);
        try {
            mClient = new MqttClient("tcp://10.7.200.141:1883", mDeviceId, mDataStore);
 
        } catch (MqttException e) {
            e.printStackTrace();
        }
 
        mConnHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    mClient.connect();
 
                    mClient.subscribe(topicFilters, qos);
 
                    mClient.setCallback(IbmMqttService.this);
 
                    mStarted = true; // Service is now connected
 
                           Log.e(DEBUG_TAG, "�ɹ��������ͷ���������������������");
 
                    startKeepAlives();
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
    /**
     * ��������������
     */
    private void startKeepAlives() {
        Intent i = new Intent();
        i.setClass(this, IbmMqttService.class);
        i.setAction(ACTION_KEEPALIVE);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + MQTT_KEEP_ALIVE,
                MQTT_KEEP_ALIVE, pi);
    }
 
    /**
     * ȡ���Ѿ����ڵ�����
     */
    private void stopKeepAlives() {
        Intent i = new Intent();
        i.setClass(this, IbmMqttService.class);
        i.setAction(ACTION_KEEPALIVE);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        mAlarmManager.cancel(pi);
    }
 
    /**
     * �����������ݵ�������
     */
    private synchronized void keepAlive() {
        if (isConnected()) {
            try {
                sendKeepAlive();
                return;
            } catch (MqttConnectivityException ex) {
                ex.printStackTrace();
                reconnectIfNecessary();
            } catch (MqttPersistenceException ex) {
                ex.printStackTrace();
                stop();
            } catch (MqttException ex) {
                ex.printStackTrace();
                stop();
            }
        }
    }
 
    /**
     * ��������������Ǳ����
     */
    private synchronized void reconnectIfNecessary() {
 
        if (mStarted && mClient == null) {
            connect();
        } else {
                   Log.e(DEBUG_TAG, "��������û��������mStarted:" + String.valueOf(mStarted) +  "mClient: "+ mClient);
        }
    }
 
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }
 
    /**
     * ͨ��ConnectivityManager��ѯ��������״̬
     *
     * @return �������״̬�����򷵻�true��֮flase
     */
    private boolean isNetworkAvailable() {
        NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
 
        return (info == null) ? false : info.isConnected() && info.isAvailable();
 
    }
 
    /**
     * �ж����ͷ����Ƿ�����
     *
     * @return ��������ӵ��򷵻�true��֮false
     */
    private boolean isConnected() {
        if (mStarted && mClient != null && !mClient.isConnected()) {
                   Log.e(DEBUG_TAG, "�ж����ͷ����Ѿ��Ͽ�");
        }
 
        if (mClient != null) {
            return (mStarted && mClient.isConnected()) ? true : false;
        }
 
        return false;
    }
 
    /**
     * ����״̬�����仯������
     */
    private final BroadcastReceiver mConnectivityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (isNetworkAvailable()) {
                       Log.e(DEBUG_TAG, "�������ӷ����˱仯--��������");
                reconnectIfNecessary();
            } else {
                       Log.e(DEBUG_TAG, "�������ӷ����˱仯--����Ͽ�");
                stopKeepAlives();
                mClient = null;
            }
        }
    };
 
    /**
     * ���ͱ������ӵ�ָ��������
     *
     * @return MqttDeliveryToken specified token you can choose to wait for completion
     */
    private synchronized MqttDeliveryToken sendKeepAlive()
            throws MqttConnectivityException, MqttPersistenceException, MqttException {
        if (!isConnected())
            throw new MqttConnectivityException();
 
        if (mKeepAliveTopic == null) {
            mKeepAliveTopic = mClient.getTopic(
                    String.format(Locale.US, MQTT_KEEP_ALIVE_TOPIC_FORAMT, mDeviceId));
        }
 
               Log.e(DEBUG_TAG, "�����������������url�� " + MQTT_BROKER);
 
        MqttMessage message = new MqttMessage(MQTT_KEEP_ALIVE_MESSAGE);
        message.setQos(MQTT_KEEP_ALIVE_QOS);
 
        return mKeepAliveTopic.publish(message);
    }
 
    /**
     * ��ѯ�Ƿ��Ѿ���һ��������������
     *
     * @return ����Ѿ���һ���������������򷵻�true��֮false
     */
    private synchronized boolean hasScheduledKeepAlives() {
        Intent i = new Intent();
        i.setClass(this, IbmMqttService.class);
        i.setAction(ACTION_KEEPALIVE);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_NO_CREATE);
 
        return (pi != null) ? true : false;
    }
 
 
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
 
    /**
     * ���Ӷ�ʧ�ص�
     */
    @Override
    public void connectionLost(Throwable arg0) {
               Log.e(DEBUG_TAG, "���ͻص��������Ӷ�ʧconnectionLost����ִ��");
        stopKeepAlives();
 
        mClient = null;
 
        if (isNetworkAvailable()) {
            reconnectIfNecessary();
        }
    }
 
   
 
    /**
     * MqttConnectivityException Exception class
     */
    private class MqttConnectivityException extends Exception {
        private static final long serialVersionUID = -7385866796799469420L;
    }

	@Override
	public void deliveryComplete(MqttDeliveryToken arg0) {
		 Log.e(DEBUG_TAG, "���ͻص�����deliveryComplete����ִ��");
		
	}

	@Override
	public void messageArrived(MqttTopic arg0, MqttMessage arg1)
			throws Exception {
		// TODO Auto-generated method stub
		 Log.e(DEBUG_TAG, "�յ�������Ϣ����  Topic: "    + arg0 +
                 " Message: "  + new String(arg1.getPayload()) +
                  "QoS: "  + arg1.getQos());
		 
		 String tr = new String(arg1.getPayload());
		 
		 Intent intent1 = new Intent("com.aux.pushcallBack");
	        intent1.putExtra("showmessage", tr.toString());
	        IbmMqttService.this.sendBroadcast(intent1);
	}
}
