package com.ulic.ulweb.ulweb.util;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class PorjectTask extends TimerTask {

	public static int initIndexTaskFlag = 0;
	public static int flashTime = 360;
	static int count = 0;
	
	public static Timer timer = null;
	
	public void run(){
		new IndexAction().initList();
		// 清空首页页面内容缓存
		com.ulic.ulweb.ulweb2.web.action.IndexAction.clearCache();
		
		System.out.println("-------ulweb list init" + Calendar.getInstance().getTime().toString());
		System.out.println("count:" + count++);
		System.out.println("flashTime:" + flashTime);
		
		
	}
	
	public void start(){
		if(initIndexTaskFlag == 0){
			System.out.println("---------task-start");
			timer = new Timer(true);
			timer.schedule(this,1000, flashTime*60*1000);
			initIndexTaskFlag = 1;
		}
		
	}
	
	public void shutdown(){
		if(initIndexTaskFlag == 1){
			System.out.println("---------task-close");
			timer.cancel();
			timer = null;
			initIndexTaskFlag = 0;
		}
	}
		
}
