package com.framework.mq.test;
import java.net.URISyntaxException;
import java.util.LinkedList;

import org.fusesource.hawtbuf.AsciiBuffer;
import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Future;
import org.fusesource.mqtt.client.FutureConnection;
import org.fusesource.mqtt.client.MQTT;
import org.fusesource.mqtt.client.QoS;

import com.framework.mq.util.JsonUtil;

/**
 * 最少使用包JAR
 *	<classpathentry kind="lib" path="lib/hawtbuf-1.11.jar"/>
	<classpathentry kind="lib" path="lib/mqtt-client-1.12.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-1.22.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-transport-1.22.jar"/>
 * @author tulip
 *
 */
public class MqttPublisher {

	public static void pub(String prefix,Object[] topicNames,Object[] message) throws URISyntaxException{
		try {
			String user = env("ACTIVEMQ_USER", "admin");
			String password = env("ACTIVEMQ_PASSWORD", "admin");
			String host = env("ACTIVEMQ_HOST", "10.7.200.141");
			int port = Integer.parseInt(env("ACTIVEMQ_PORT", "1883"));
			String destination ="";// arg(args, 0, "topicName");

			int messages = topicNames.length;
			
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
			mqtt.setPassword(password);

			FutureConnection connection = mqtt.futureConnection();

			connection.connect().await();


			final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
			UTF8Buffer topic = null;
			
			for( int i=0; i < messages; i ++) {
				String jsonStr = JsonUtil.getJsonFromObject(message[i]);
				destination= "";
				destination = prefix + topicNames[i].toString();
				topic = new UTF8Buffer(destination);
				 msg = new AsciiBuffer(jsonStr);
				// Send the publish without waiting for it to complete. This allows us
				// to send multiple message without blocking..
				queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));
				

				// Eventually we start waiting for old publish futures to complete
				// so that we don't create a large in memory buffer of outgoing message.s
//				if( queue.size() >= 1000 ) {
//					queue.removeFirst().await();
//				}
//
//				if( i % 1000 == 0 ) {
//					System.out.println(String.format("Sent %d messages.", i));
//				}
			}

			//queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));
			while( !queue.isEmpty() ) {
				queue.removeFirst().await();
			}

			connection.disconnect().await();

			System.exit(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void main(String []args) throws Exception {

		String user = env("ACTIVEMQ_USER", "admin");
		String password = env("ACTIVEMQ_PASSWORD", "admin");
		String host = env("ACTIVEMQ_HOST", "10.7.200.141");
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "1883"));
		final String destination = arg(args, 0, "ActiveMQ.Advisory.MasterBroker");

		int messages = 10000;
		int size = 256;

		String DATA = "abcdefghijklmnopqrstuvwxyz";
		String body = "";
		for( int i=0; i < size; i ++) {
			body += DATA.charAt(i%DATA.length());
		}
		Buffer msg = new AsciiBuffer(body);

		MQTT mqtt = new MQTT();
		mqtt.setHost(host, port);
		mqtt.setUserName(user);
		mqtt.setPassword(password);

		FutureConnection connection = mqtt.futureConnection();
		connection.connect().await();

		final LinkedList<Future<Void>> queue = new LinkedList<Future<Void>>();
		UTF8Buffer topic = new UTF8Buffer(destination);
		for( int i=1; i <= messages; i ++) {

			// Send the publish without waiting for it to complete. This allows us
			// to send multiple message without blocking..
			queue.add(connection.publish(topic, msg, QoS.AT_LEAST_ONCE, false));

			// Eventually we start waiting for old publish futures to complete
			// so that we don't create a large in memory buffer of outgoing message.s
			if( queue.size() >= 1000 ) {
				queue.removeFirst().await();
			}

			if( i % 1000 == 0 ) {
				System.out.println(String.format("Sent %d messages.", i));
			}
		}

		queue.add(connection.publish(topic, new AsciiBuffer("SHUTDOWN"), QoS.AT_LEAST_ONCE, false));
		while( !queue.isEmpty() ) {
			queue.removeFirst().await();
		}

		connection.disconnect().await();

		System.exit(0);
	}

	private static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if( rc== null )
			return defaultValue;
		return rc;
	}

	private static String arg(String []args, int index, String defaultValue) {
		if( index < args.length )
			return args[index];
		else
			return defaultValue;
	}

}
