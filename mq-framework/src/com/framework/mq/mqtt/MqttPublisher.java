package com.framework.mq.mqtt;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.fusesource.hawtbuf.AsciiBuffer;
import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Future;
import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

import com.framework.mq.IPublisher;
import com.framework.mq.util.JsonUtil;


/**
 * mqtt 发布主题实现类
 * 最少使用包JAR
 *	<classpathentry kind="lib" path="lib/hawtbuf-1.11.jar"/>
	<classpathentry kind="lib" path="lib/mqtt-client-1.12.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-1.22.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-transport-1.22.jar"/>
 * @author tulip
 *
 */
public class MqttPublisher implements IPublisher {
	
	private String user;
	private String pwd;
	private String host;
	private int port;

	
	
	public  void pub(String prefix,Object[] topicNames,Object[] messages) throws Exception{
		try {

			String destination ="";// arg(args, 0, "topicName");

			int length = topicNames.length;
			
			int size = 256;

			String DATA = "abcdefghijklmnopqrstuvwxyz";
			String body = "";
			for( int i=0; i < size; i ++) {
				body += DATA.charAt(i%DATA.length());
			}
			
			Buffer msg = null;

			MQTT mqtt = new MQTT();
			mqtt.setHost(host, port);
			mqtt.setUserName(user);
			mqtt.setPassword(pwd);

			FutureConnection connection = mqtt.futureConnection();

			connection.connect().await();


			final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
			UTF8Buffer topic = null;
			for( int i=0; i < length; i ++) {
				String jsonStr = JsonUtil.getJsonFromObject(messages[i]);
				destination= "";
				destination = prefix + topicNames[i].toString();
				topic = new UTF8Buffer(destination);
				 msg = new AsciiBuffer(jsonStr);
				// Send the publish without waiting for it to complete. This allows us
				// to send multiple message without blocking..
				queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));

				
			}

			//queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));
			while( !queue.isEmpty() ) {
				queue.removeFirst().await();
			}

			connection.disconnect().await();

			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}


	

	@Override
	public void publish(String topic, String msg) throws Exception {
		// TODO Auto-generated method stub
		publish(topic , new String[]{msg});
	}


	@Override
	public void publish(String topicName, Object[] messages) throws Exception {
		// TODO Auto-generated method stub
		try {

			Buffer buf = null;
			MQTT mqtt = new MQTT();
			mqtt.setHost(host, port);
			mqtt.setUserName(user);
			mqtt.setPassword(pwd);
			UTF8Buffer topic = new UTF8Buffer(topicName);
			FutureConnection connection = mqtt.futureConnection();
			connection.connect().await();

			final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
			
			for(Object msg : messages) {				
				String jsonStr = JsonUtil.getJsonFromObject(msg);
				buf = new AsciiBuffer(jsonStr);
				// Send the publish without waiting for it to complete. This allows us
				// to send multiple message without blocking..
				queue.add(connection.publish(topic, buf, QoS.AT_LEAST_ONCE, false));
				
				
			}

			
//			queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));

			while( !queue.isEmpty() ) {
				
				queue.removeFirst().await();
			}

			connection.disconnect().await();

//			System.exit(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}


	@Override
	public void publish(String[] topics, Object[] messages) throws Exception{
		// TODO Auto-generated method stub
		try {

			Buffer msg = null;
			MQTT mqtt = new MQTT();
			int length = topics.length;
			mqtt.setHost(host, port);
			mqtt.setUserName(user);
			mqtt.setPassword(pwd);

			FutureConnection connection = mqtt.futureConnection();
			connection.connect().await();

			final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
			
			UTF8Buffer topic = null;
			
			
			
			for(int i=0;i<length;i++) {
				
				String topicName = topics[i];	
				
				String jsonStr = JsonUtil.getJsonFromObject(messages[i]);
				
				topic = new UTF8Buffer(topicName);
				msg = new AsciiBuffer(jsonStr);
				// Send the publish without waiting for it to complete. This allows us
				// to send multiple message without blocking..
				queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));
				
				
			}

			
//			queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));

			while( !queue.isEmpty() ) {
				
				queue.removeFirst().await();
			}

			connection.disconnect().await();

//			System.exit(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}


	@Override
	public void publish(Map topicMsgMap) throws Exception{
		publish("",topicMsgMap);
	}


//	@Override
	public void publish(String prefix, Map<String,Object> topicMsgMap) throws Exception{
		try {

			Buffer msg = null;
			MQTT mqtt = new MQTT();
			mqtt.setHost(host, port);
			mqtt.setUserName(user);
			mqtt.setPassword(pwd);

			FutureConnection connection = mqtt.futureConnection();
			connection.connect().await();

			final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
			
			UTF8Buffer topic = null;
			
			Set<Map.Entry<String, Object>> topicSet = topicMsgMap.entrySet();
			
			for(Map.Entry<String, Object> entry : topicSet) {
				
				String key = entry.getKey();	
				String destination = "";
				Object obj = entry.getValue();
				String jsonStr = JsonUtil.getJsonFromObject(obj);
				destination = prefix + key;
				topic = new UTF8Buffer(destination);
				msg = new AsciiBuffer(jsonStr);
				// Send the publish without waiting for it to complete. This allows us
				// to send multiple message without blocking..
				queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));
				
				
			}

			
//			queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));

			while( !queue.isEmpty() ) {
				
				queue.removeFirst().await();
			}

			connection.disconnect().await();

//			System.exit(0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
		
	}
	
	
	public String getUser() {
		return user;
	}




	public void setUser(String user) {
		this.user = user;
	}




	public String getPwd() {
		return pwd;
	}




	public void setPwd(String pwd) {
		this.pwd = pwd;
	}




	public String getHost() {
		return host;
	}




	public void setHost(String host) {
		this.host = host;
	}




	public int getPort() {
		return port;
	}




	public void setPort(int port) {
		this.port = port;
	}


}
