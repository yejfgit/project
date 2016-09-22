package com.framework.mq;

import java.util.Map;

import com.framework.mq.mqtt.MqttPublisher;



public class PublisherFactory {

	private static IPublisher install;
	
	static{
		
		install = new MqttPublisher();
	}
	
	
	/**
	 * ������Ϣ
	 * @param topic ����
	 * @param msg����Ϣ
	 */
	public static void publish(String topic,String msg){
		
	}
	
	/**
	 * һ�η���������Ϣ
	 * @param topic ����
	 * @param msg����Ϣ
	 */
	public static void publish(String topic,String[] msg){
		
	}
	
	
	/**
	 * �������ⷢ��������Ϣ
	 * @param topic
	 * @param msg
	 */
	public static void publish(String[] topic,String[] msg){
		
	}
	
	/**
	 * �������ⷢ��������Ϣ
	 * @param topicMsgMap keyΪ���⡡valueΪ��Ϣ�ɶ���ʹ��list
	 */
	public static void publish(Map topicMsgMap){
		
	}
	
	/**
	 * ������Ϣ����Ϣ�Զ�ת��json��ʽ
	 * ǰ�ΪTC_ORDER ����map��key��Ϊ���
	 * ���硡������ҽ�����ѡ���Ҫ�����������⡡ǰꡣ�TC_NEWORDER ��������Ϊ01�� ��ô��������ΪTC_NEWORDER01
	 * @param prefix ����ǰ�
	 * @param topicMsgMap��topicMsgMap keyΪ���⡡valueΪ��Ϣ�ɶ���ʹ��list
	 */
	public static void publish(String prefix, Map<String,Object> topicMsgMap) throws Exception{
		
		install.publish(prefix, topicMsgMap);
	}
	
}
