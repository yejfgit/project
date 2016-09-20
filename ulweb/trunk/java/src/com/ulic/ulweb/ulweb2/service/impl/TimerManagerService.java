package com.ulic.ulweb.ulweb2.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.ulweb2.entity.UlwebTask;
import com.ulic.ulweb.ulweb2.service.ITimerManagerService;
import com.ulic.ulweb.ulweb2.service.ITimerTask;

public class TimerManagerService implements ITimerManagerService{

	private static final int ZERO = 0;
	private static int runningTask = 0;
	private static Map<String , UlwebTask> taskList = new HashMap<String , UlwebTask>(10);
	
	
	public String addRunningTask(String taskName, ITimerTask task) {
		// TODO Auto-generated method stub
		
		String taskId = this.getTaskId(taskName, TimerManagerService.ZERO);
		UlwebTask ulwebTask = new UlwebTask();
		ulwebTask.setLastTime(new Date(System.currentTimeMillis()));
		ulwebTask.setTaskId(taskId);
		TimerManagerService.addOneRunning();
		TimerManagerService.addTaskToList(taskId, ulwebTask);	
		
		return taskId;
	}

	public void reportRunning(String taskId) {
		// TODO Auto-generated method stub
		UlwebTask ulwebTask = TimerManagerService.taskList.get(taskId);
		ulwebTask.setLastTime(new Date(System.currentTimeMillis()));
		ulwebTask.runOnce();
	}

	public boolean startTask(String serviceId, long secondsOnNextRun) {
		// TODO Auto-generated method stub
		ITimerTask t = (ITimerTask) ServiceLocator.getService(serviceId);
		t.startThisTask(this, serviceId, secondsOnNextRun);
		return true;
	}

	public boolean stopTask(String taskId) {
		// TODO Auto-generated method stub
		try {
			TimerManagerService.taskList.get(taskId).getTask().stopThisTask();
		} catch (Exception e) {
			
			return false;
		}
		return true;
	}

	public void subRunningTask(String taskId) {
		// TODO Auto-generated method stub
		TimerManagerService.taskList.remove(taskId);
	}

	
	
	
	/**
	 * 向正在运行中的任务计数中增加一个。
	 */
	private static synchronized void addOneRunning(){		
		TimerManagerService.runningTask ++;		
	}
	
	private static synchronized void addTaskToList(String taskId, UlwebTask task){		
		TimerManagerService.taskList.put(taskId, task);
	}
	
	
	
	/**
	 * 检查taskName是否有值，如果没有，则按0，1，2，3一直排下去。
	 * 调用此方法时参数请使用0，表示从0开始检查有没有被使用。
	 */
	private String getTaskId(String taskName,Integer zero){

		if(TimerManagerService.taskList.get(taskName + zero.toString()) == null){
			return taskName + zero.toString();
		}else{
			return this.getTaskId(taskName, zero + 1);
		}
		
	}
	
	public Map<String, UlwebTask> getTaskList(){
		
		return TimerManagerService.taskList;
	}
	
	
	
	
}
