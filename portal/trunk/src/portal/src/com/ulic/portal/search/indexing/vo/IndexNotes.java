package com.ulic.portal.search.indexing.vo;

import java.util.Date;

public class IndexNotes {
	
	private int sysId;
	
	private String lastIndexId;
	
	private Date createDate;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastIndexId() {
		return lastIndexId;
	}

	public void setLastIndexId(String lastIndexId) {
		this.lastIndexId = lastIndexId;
	}

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}
	
	
}
