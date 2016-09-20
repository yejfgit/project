package com.ulic.ulweb.ulweb2.entity;

import java.util.Date;

import com.ulic.ulweb.ulweb2.service.ITimerTask;

public class UlwebTask {

	private Date startTime;
	private Date lastTime;
	private int runTimes;
	private ITimerTask task;
	private String taskId;
	
	
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public int getRunTimes() {
		return runTimes;
	}
	public void setRunTimes(int runTimes) {
		this.runTimes = runTimes;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public ITimerTask getTask() {
		return task;
	}
	public void setTask(ITimerTask task) {
		this.task = task;
	}
	public void runOnce(){
		this.runTimes ++;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	
	
}
