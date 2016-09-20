package com.mvc.entity;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String[] args) {
		// ���ӱ��ص� Redis ����
		Jedis jedis = new Jedis("localhost");
		System.out.println("Connection to server sucessfully");
		// �鿴�����Ƿ�����
		System.out.println("Server is running: " + jedis.ping());

		// ���� redis �ַ�������
		jedis.set("w3ckey", "Redis tutorial");
		// ��ȡ�洢�����ݲ����
		System.out.println("Stored string in redis:: " + jedis.get("w3ckey"));

		// �洢���ݵ��б���
		jedis.lpush("tutorial-list", "Redis");
		jedis.lpush("tutorial-list", "Mongodb");
		jedis.lpush("tutorial-list", "Mysql");
		// ��ȡ�洢�����ݲ����
		List<String> list = jedis.lrange("tutorial-list", 0, 5);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Stored string in redis:: " + list.get(i));
		}
		
		
		/* // ��ȡ���ݲ����
		List<String> list2 = (List<String>) jedis.keys("*");
	     for(int i=0; i<list2.size(); i++) {
	       System.out.println("List of stored keys:: "+list2.get(i));
	     }*/
	}
}
