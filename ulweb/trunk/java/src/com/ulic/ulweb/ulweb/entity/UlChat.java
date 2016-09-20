package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlChat extends AbstractBean{
	private String ip;
	private String content;
	private Timestamp time;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
}
