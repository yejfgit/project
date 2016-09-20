package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlReport extends AbstractBean{

	private Timestamp saveTime;
	private String ip;
	private int personal;
	private int group;
	private int bank;
	public int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public Timestamp getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}
	
	
}
