package com.framework.mq.amqp;



import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.qpid.jms.JmsConnectionFactory;


/**
 * 
 * @author tulip
 * 暂时不可用
 * <classpathentry kind="lib" path="lib/qpid-jms-client.jar"/>
	<classpathentry kind="lib" path="lib/slf4j-api-1.7.13.jar"/>
	<classpathentry kind="lib" path="lib/proton-j-0.11.0.jar"/>
 */
public class AmqpPublisher {

    public static void main(String[] args) throws Exception {

        final String TOPIC_PREFIX = "topic://";

        String user = env("ACTIVEMQ_USER", "admin");
        String password = env("ACTIVEMQ_PASSWORD", "admin");
        String host = env("ACTIVEMQ_HOST", "10.7.200.141");
        int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));

        String connectionURI = "amqp://" + host + ":" + port;
        String destinationName = arg(args, 0, "topic://event");

        int messages = 10000;
        int size = 256;

        String DATA = "abcdefghijklmnopqrstuvwxyz";
        String body = "";
        for (int i = 0; i < size; i++) {
            body += DATA.charAt(i % DATA.length());
        }

		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
		JmsConnectionFactory factory = new JmsConnectionFactory(connectionURI);	//"tcp://localhost:61616"

		//
        //ConnectionFactoryImpl factory = new ConnectionFactoryImpl(host, port, user, password);
        Connection connection = factory.createConnection(user, password);
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = null;
        if (destinationName.startsWith(TOPIC_PREFIX)) {
            destination = session.createTopic(destinationName.substring(TOPIC_PREFIX.length()));
        } else {
            destination = session.createQueue(destinationName);
        }

        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 1; i <= messages; i++) {
            TextMessage msg = session.createTextMessage("#:" + i);
            msg.setIntProperty("id", i);
            producer.send(msg);
            if ((i % 1000) == 0) {
                System.out.println(String.format("Sent %d messages", i));
            }
        }

        producer.send(session.createTextMessage("SHUTDOWN"));
        Thread.sleep(1000 * 3);
        connection.close();
        System.exit(0);
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if (rc == null)
            return defaultValue;
        return rc;
    }

    private static String arg(String[] args, int index, String defaultValue) {
        if (index < args.length)
            return args[index];
        else
            return defaultValue;
    }

}
