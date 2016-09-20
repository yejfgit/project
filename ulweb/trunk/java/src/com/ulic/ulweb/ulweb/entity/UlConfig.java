package com.ulic.ulweb.ulweb.entity;

public class UlConfig {

	private int configId;
	private String constantName;
	private String columnName;
	private String constantData ;
	private String ip;
	private String date;
	private String updateUser;
	private String desc;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public int getConfigId() {
		return configId;
	}
	public void setConfigId(int configId) {
		this.configId = configId;
	}
	public String getConstantData() {
		return constantData;
	}
	public void setConstantData(String constantData) {
		this.constantData = constantData;
	}
	public String getConstantName() {
		return constantName;
	}
	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	
}
