package com.framework.mq.stomp;

import org.fusesource.stomp.jms.*;
import javax.jms.*;

/**
 * 	<classpathentry kind="lib" path="lib/stompjms-client-1.19.jar"/>
	<classpathentry kind="lib" path="lib/hawtbuf-1.11.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-1.22.jar"/>
	<classpathentry kind="lib" path="lib/hawtdispatch-transport-1.22.jar"/>
	<classpathentry kind="lib" path="lib/geronimo-jms_1.1_spec-1.1.1.jar"/>
 * @author tulip
 *
 */
public class StompPublisher {

	public static void main(String []args) throws JMSException {

		String user = env("ACTIVEMQ_USER", "admin");
		String password = env("ACTIVEMQ_PASSWORD", "admin");
		String host = env("ACTIVEMQ_HOST", "10.7.200.141");
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61613"));
		String destination = arg(args, 0, "/topic/event");

		int messages = 10000;
		int size = 256;

		String DATA = "abcdefghijklmnopqrstuvwxyz";
		String body = "";
		for( int i=0; i < size; i ++) {
			body += DATA.charAt(i%DATA.length());
		}

		StompJmsConnectionFactory factory = new StompJmsConnectionFactory();
		factory.setBrokerURI("tcp://" + host + ":" + port);

		Connection connection = factory.createConnection(user, password);
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = new StompJmsDestination(destination);
		MessageProducer producer = session.createProducer(dest);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		for( int i=1; i <= messages; i ++) {
			TextMessage msg = session.createTextMessage(body);
			msg.setIntProperty("id", i);
			producer.send(msg);
			if( (i % 1000) == 0) {
				System.out.println(String.format("Sent %d messages", i));
			}
		}

		producer.send(session.createTextMessage("SHUTDOWN"));
		connection.close();

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
