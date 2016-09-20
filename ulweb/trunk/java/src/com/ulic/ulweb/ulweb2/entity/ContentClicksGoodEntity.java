package com.ulic.ulweb.ulweb2.entity;

import java.util.Date;

public class ContentClicksGoodEntity implements java.io.Serializable{

	private int id;
	 
	private long clicksNums;
	
	private int contentId;
	
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getClicksNums() {
		return clicksNums;
	}

	public void setClicksNums(long clicksNums) {
		this.clicksNums = clicksNums;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
