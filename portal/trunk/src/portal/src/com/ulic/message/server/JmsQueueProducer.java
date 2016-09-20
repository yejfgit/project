package com.ulic.message.server;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * jms producer
 * 
 * @author wengxf
 * 
 */
public class JmsQueueProducer {

	public static void main(String[] args) throws Exception {
		long ts = System.currentTimeMillis();
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"failover:tcp://10.18.2.174:61616");

		Connection connection = factory.createConnection();
		connection.start();

		Queue queue = new ActiveMQQueue("PORTAL_REQUEST_QUEUE");

		final Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);
		MessageProducer producer = session.createProducer(queue);
		
		for (int i = 0; i < 5; i++) {
			Message message = session.createTextMessage("HaHa Jms! - " + i);
			producer.send(message);
			System.out.println("sent: " + ((TextMessage) message).getText());
		}
		producer.close();
		session.close();
		connection.close();
		
		long te = System.currentTimeMillis();
		System.out.println("it cost: " + (te - ts) + "ms");
	}

}
