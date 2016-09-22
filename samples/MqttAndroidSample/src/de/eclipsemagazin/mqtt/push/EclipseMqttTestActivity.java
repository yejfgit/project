package de.eclipsemagazin.mqtt.push;

import java.util.Calendar;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * requirte lib paho-mqtt-client-1.0.1.jar
 * @author tulip
 *
 */
public class EclipseMqttTestActivity extends Activity {

    public static final String SERVICE_CLASSNAME = "de.eclipsemagazin.mqtt.push.MQTTService";
    private Button button;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button = (Button) findViewById(R.id.button1);
        //startBlackIceService();
        updateButton();
       // Intent intent = getIntent();
        //String str = intent.getStringExtra("showmessage");
        //tv = (TextView)findViewById(R.id.showmessage);    
        //tv.setText(str);
        IntentFilter filter = new IntentFilter("com.aux.pushcallBack");
        registerReceiver(new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				String str = arg1.getStringExtra("showmessage");
		        tv = (TextView)findViewById(R.id.showmessage);    
		        //tv.setText(str);
		        tv.append("\n" +str+"\n" +new java.sql.Timestamp(Calendar
                        .getInstance().getTime().getTime()));
			}
		}, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateButton();
    }

    @Override
	protected void onNewIntent(Intent intent) {
        
	}

	private void updateButton() {
        if (serviceIsRunning()) {
            button.setText("Stop Service");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    button.setText("Start Service");
                    stopBlackIceService();
                    updateButton();
                }
            });

        } else {
            button.setText("Start Service");
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    button.setText("Stop Service");
                    startBlackIceService();
                    updateButton();
                }
            });
        }
    }

    private void startBlackIceService() {

        final Intent intent = new Intent(this, MQTTService.class);
       
        startService(intent);
       
    }

    private void stopBlackIceService() {
    	 final Intent intent = new Intent(this, MQTTService.class);
         
         stopService(intent);
    }

    private boolean serviceIsRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (SERVICE_CLASSNAME.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
