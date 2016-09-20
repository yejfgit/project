package com.ulic.message.server;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.ulic.portal.search.indexing.dao.CusSystemDao;
import com.ulic.portal.search.indexing.entity.CusSystem;
import com.ulic.portal.search.indexing.service.IIndexService;
import com.ulic.portal.search.indexing.vo.UlDocument;



/**
 * 待办事项的服务端
 * @author wengxf
 * 2012-12-3
 */

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TaskServer implements MessageListener {
	
	/**
	 * 自动注入Dao
	 */
	@Resource
	private CusSystemDao cusSystemDao;
	
	@Resource
	private IIndexService indexService;
	
	private static Connection connection;
	
	private static Session session;
	
			
	/**
	 * 启动监听器
	 *
	 */
	public static void startTaskListener() {
		
		try {
			
			// 关闭已有的session和connection
			if (session != null) {
				session.close();
				session = null;
			}
			if (connection != null) {
				connection.stop();
				connection.close();
				connection = null;
			}
			
			
			ConnectionFactory factory = new ActiveMQConnectionFactory(
			ResourceUtil.getProperty("message_server"));
			System.out.println("message_server:" + ResourceUtil.getProperty("message_server"));
		
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			
			
//			// 为所有系统分别增加消息监听器
//			List systemList = cusSystemDao.getList("CusSystem");
//			for (int i = 0; i < systemList.size(); i++) {
//				CusSystem system = (CusSystem) systemList.get(i);
//				
//				Queue queue = new ActiveMQQueue(system.getQueueName());
//				MessageConsumer consumer = session.createConsumer(queue);
//				consumer.setMessageListener(new TaskServer());
//				System.out.println("message listening... for " + system.getSysName());
//			}
			
			Queue queue = new ActiveMQQueue(ResourceUtil.getProperty("queue_name"));
			MessageConsumer consumer = session.createConsumer(queue);
			consumer.setMessageListener(new TaskServer());
			System.out.println("message listening... for " + queue.getQueueName());
	

		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 监听消息
	 */
	public void onMessage(Message msg) {
		
		try {
			
			UlDocument ud = (UlDocument)(((ObjectMessage) msg).getObject());
			System.out.println("I got it!");
			
			indexService.createIndex(ud);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		startTaskListener();
	}
	
}
