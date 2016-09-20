package com.ulic.ulweb.ulweb2.service;

import java.util.Timer;
import java.util.TimerTask;

public abstract class ITimerTask extends TimerTask{

	private ITimerManagerService tm = null;
	Timer timer = new Timer();
	private String taskId = null;
	
	/**
	 * 启动这个任务，即时启动
	 * @param itm 任务管理类
	 * @param taskName 这个任务任务名，作为管理标识
	 * @param runOnNextSeconds 下一次运行这个任务的时间，以秒计。
	 */
	public void startThisTask(ITimerManagerService itm, String taskName, long runOnNextSeconds){
		tm = itm;
		taskId = tm.addRunningTask(taskName,this);
		try {
			timer.scheduleAtFixedRate(this, 0, runOnNextSeconds * 1000);
			
		} catch (Exception e) {
			try {
				timer.cancel();
			} catch (Exception es) {
				es.printStackTrace();
			}
			tm.subRunningTask(taskId);
		}
		
	}	
	
	public void stopThisTask(){
		tm.subRunningTask(taskId);
		timer.cancel();
	}
	
	public void run(){
		tm.reportRunning(taskId);
		this.runBody();
	}
	
	/**
	 * 在run方法中向管理任务的类返回了一个信息表示这个任务还在进行，
	 * 所以子类要重写runBody这个方法，将需要运行的内容写在这里。
	 */
	public abstract void runBody();
	
}
