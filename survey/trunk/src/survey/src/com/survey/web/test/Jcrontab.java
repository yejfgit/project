package com.survey.web.test;

import com.survey.util.UlicSendMail;

public class Jcrontab implements Runnable {
	
	public Jcrontab(String[] args){
		System.out.println("========================test====================");
	}
	
	public void run() {
		// TODO Auto-generated method stub
		UlicSendMail.sendMail("zhangch003@ulic.com.cn", "测试测试", "测试测试","");
		System.out.println("========================test====================");
	}
}
