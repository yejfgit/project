package com.ulic.ulweb.ulweb.entity;

public class Attachment {
	private int fileid;
	private String attName;
	private int docid;
	private int aused;
	private String realName;
	public String getAttName() {
		return attName;
	}
	public void setAttName(String attName) {
		this.attName = attName;
	}
	public int getAused() {
		return aused;
	}
	public void setAused(int aused) {
		this.aused = aused;
	}
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public int getFileid() {
		return fileid;
	}
	public void setFileid(int fileid) {
		this.fileid = fileid;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
}
