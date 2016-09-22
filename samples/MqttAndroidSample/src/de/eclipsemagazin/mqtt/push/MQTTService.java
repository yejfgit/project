package de.eclipsemagazin.mqtt.push;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.MemoryPersistence;

/**
 * @author Dominik Obermaier
 */
public class MQTTService extends Service {

    //public static final String BROKER_URL = "tcp://broker.mqttdashboard.com:1883";
    //public static final String BROKER_URL = "tcp://test.mosquitto.org:1883";
	public static final String BROKER_URL = "tcp://10.7.200.141:1883";
    /* In a real application, you should get an Unique Client ID of the device and use this, see
    http://android-developers.blogspot.de/2011/03/identifying-app-installations.html */
    public static final String clientId = "simulator";
    //public static final String clientId = "android";
    public static final String TOPIC = "TC_NEWORDER84";
    public static final String QUEUE = "queue_simulator";
    
    private MqttClient mqttClient;


    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {

        try {
            mqttClient = new MqttClient(BROKER_URL, clientId, new MemoryPersistence());
            
            MqttConnectOptions options= new MqttConnectOptions();
            
            //false那么客户机创建的任何预订都会被添加至客户机在连接之前就已存在的所有预订          
            options.setCleanSession(false);
            //记录预定等待30秒信息，可以重新启动得到原来的信息，启动后30秒如果不发送，则不会主动再获得信息
            options.setKeepAliveInterval(30);
            mqttClient.setCallback(new PushCallback(this));
            mqttClient.connect(options);

            //Subscribe to all subtopics of homeautomation
            mqttClient.subscribe(TOPIC);  
            
           // mqttClient.subscribe(TOPIC);


        } catch (MqttException e) {
            Toast.makeText(getApplicationContext(), "Something went wrong!" + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        try {
        	
            mqttClient.disconnect(0);
            
        } catch (MqttException e) {
            Toast.makeText(getApplicationContext(), "Something went wrong!" + e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
