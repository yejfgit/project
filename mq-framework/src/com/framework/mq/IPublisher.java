package com.framework.mq;

import java.util.Map;

public interface IPublisher {

	
	/**
	 * ������Ϣ
	 * @param topic ����
	 * @param msg����Ϣ
	 */
	void publish(String topic,String msg) throws Exception;
	
	/**
	 * һ�η���������Ϣ
	 * @param topic ����
	 * @param msg����Ϣ
	 */
	void publish(String topic,Object[] messages) throws Exception;
	
	
	/**
	 * �������ⷢ��������Ϣ
	 * @param topic
	 * @param msg
	 */
	void publish(String[] topic,Object[] messages) throws Exception;
	
	/**
	 * �������ⷢ��������Ϣ
	 * @param topicMsgMap keyΪ���⡡valueΪ��Ϣ�ɶ���ʹ��list
	 */
	void publish(Map topicMsgMap) throws Exception;
	
	/**
	 * ������Ϣ����Ϣ�Զ�ת��json��ʽ
	 * ���硡������ҽ�����ѡ���Ҫ�����������⡡����ǰ�ΪTC_ORDER ������Ϊ01 ��ô��������ΪTC_ORDER01
	 * @param prefix ����ǰ�
	 * @param topicMsgMap��topicMsgMap keyΪ���⡡valueΪ��Ϣ�ɶ���ʹ��list
	 */
	void publish(String prefix,  Map<String,Object> topicMsgMap) throws Exception;
	
	
}
