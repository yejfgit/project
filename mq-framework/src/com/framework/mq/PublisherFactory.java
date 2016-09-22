package com.framework.mq;

import java.util.Map;

import com.framework.mq.mqtt.MqttPublisher;



public class PublisherFactory {

	private static IPublisher install;
	
	static{
		
		install = new MqttPublisher();
	}
	
	
	/**
	 * 发布消息
	 * @param topic 主题
	 * @param msg　消息
	 */
	public static void publish(String topic,String msg){
		
	}
	
	/**
	 * 一次发布多条消息
	 * @param topic 主题
	 * @param msg　消息
	 */
	public static void publish(String topic,String[] msg){
		
	}
	
	
	/**
	 * 向多个主题发布多条消息
	 * @param topic
	 * @param msg
	 */
	public static void publish(String[] topic,String[] msg){
		
	}
	
	/**
	 * 向多个主题发布多条消息
	 * @param topicMsgMap key为主题　value为消息可多条使用list
	 */
	public static void publish(Map topicMsgMap){
		
	}
	
	/**
	 * 发送消息　消息自动转成json格式
	 * 前辍为TC_ORDER 并以map的key做为后辍
	 * 例如　病区新医嘱提醒　需要按病区分主题　前辍：TC_NEWORDER 　病区号为01　 那么主题名就为TC_NEWORDER01
	 * @param prefix 主题前辍
	 * @param topicMsgMap　topicMsgMap key为主题　value为消息可多条使用list
	 */
	public static void publish(String prefix, Map<String,Object> topicMsgMap) throws Exception{
		
		install.publish(prefix, topicMsgMap);
	}
	
}
