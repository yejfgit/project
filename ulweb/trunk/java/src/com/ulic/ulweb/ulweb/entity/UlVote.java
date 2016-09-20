package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlVote extends AbstractBean {
	private int voteId;

	private String voteTitle;

	private int isIpLimit;

	private int isInvalidate;

	private Timestamp insertTime;

	private int voteClass;

	private int chackVoteClass;

	private int voteAdminId;
	
	private int voteType;
	


	

	public int getVoteType() {
		return voteType;
	}

	public void setVoteType(int voteType) {
		this.voteType = voteType;
	}

	public int getChackVoteClass() {
		return chackVoteClass;
	}

	public void setChackVoteClass(int chackVoteClass) {
		this.chackVoteClass = chackVoteClass;
	}

	public Timestamp getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	public int getIsInvalidate() {
		return isInvalidate;
	}

	public void setIsInvalidate(int isInvalidate) {
		this.isInvalidate = isInvalidate;
	}

	public int getIsIpLimit() {
		return isIpLimit;
	}

	public void setIsIpLimit(int isIpLimit) {
		this.isIpLimit = isIpLimit;
	}

	public int getVoteAdminId() {
		return voteAdminId;
	}

	public void setVoteAdminId(int voteAdminId) {
		this.voteAdminId = voteAdminId;
	}

	public int getVoteClass() {
		return voteClass;
	}

	public void setVoteClass(int voteClass) {
		this.voteClass = voteClass;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public String getVoteTitle() {
		return voteTitle;
	}

	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}

}
