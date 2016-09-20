package com.ulic.ulweb.ulweb2.service;

public interface ITimerManagerService {

	/**
	 * 向任务计数池中加一个任务计数，说明有一个任务正在跑
	 */
	public String addRunningTask(String taskName,ITimerTask task);
		
	/**
	 * 从任务计数池中减去一个任务计数，说明有一个任务被停掉或是出现问题，自动停掉了
	 */
	public void subRunningTask(String taskId);
	
	
	
	
	/**
	 * 启动一个任务,设置下次运行时间，下次运行时间为0的话，只运行一次。
	 */
	public boolean startTask(String serviceId, long secondsOnNextRun);
	
	/**
	 * 停掉一个任务
	 */
	public boolean stopTask(String taskId);
	
	/**
	 * 向timerManager报告此任务正在运行。 
	 */
	public void reportRunning(String taskId);
	
	
	
	
	
}
