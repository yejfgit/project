package com.framework.mq;

import java.util.Map;

public interface IPublisher {

	
	/**
	 * 发布消息
	 * @param topic 主题
	 * @param msg　消息
	 */
	void publish(String topic,String msg) throws Exception;
	
	/**
	 * 一次发布多条消息
	 * @param topic 主题
	 * @param msg　消息
	 */
	void publish(String topic,Object[] messages) throws Exception;
	
	
	/**
	 * 向多个主题发布多条消息
	 * @param topic
	 * @param msg
	 */
	void publish(String[] topic,Object[] messages) throws Exception;
	
	/**
	 * 向多个主题发布多条消息
	 * @param topicMsgMap key为主题　value为消息可多条使用list
	 */
	void publish(Map topicMsgMap) throws Exception;
	
	/**
	 * 发送消息　消息自动转成json格式
	 * 例如　病区新医嘱提醒　需要按病区分主题　比如前辍为TC_ORDER 病区号为01 那么主题名就为TC_ORDER01
	 * @param prefix 主题前辍
	 * @param topicMsgMap　topicMsgMap key为主题　value为消息可多条使用list
	 */
	void publish(String prefix,  Map<String,Object> topicMsgMap) throws Exception;
	
	
}
