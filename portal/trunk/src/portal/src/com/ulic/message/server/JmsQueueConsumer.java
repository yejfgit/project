package com.ulic.message.server;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * jms consumer
 * 
 * @author wengxf
 * 
 */
public class JmsQueueConsumer implements MessageListener {

	public static void main(String[] args) throws Exception {
		long ts = System.currentTimeMillis();
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"failover:tcp://10.18.2.174:61616");

		Connection connection = factory.createConnection();
		connection.start();

		Queue queue = new ActiveMQQueue("PORTAL_REQUEST_QUEUE");

		final Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new JmsQueueConsumer());
		
//		Message recvMessage = consumer.receive();
//		System.out.println("received: " + ((TextMessage) recvMessage).getText());
//		
//		consumer.close();
//		session.close();
//		connection.close();
		
		
		long te = System.currentTimeMillis();
		System.out.println("it cost: " + (te - ts) + "ms");
	}

	public void onMessage(Message arg0) {
		
		try {
			System.out.println("received: " + ((ObjectMessage) arg0).getObject());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
