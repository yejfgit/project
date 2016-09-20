package com.ulic.ulweb.ulweb2.entity;

import java.util.Date;

public class MonitorEntity implements java.io.Serializable{

	private int id;
	
	private String ip;
	
	private String url;
	
	private Date accessTime;

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
