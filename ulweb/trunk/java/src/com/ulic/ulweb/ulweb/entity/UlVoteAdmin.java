package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;
import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlVoteAdmin extends AbstractBean{

	private int voteAdminId;
	private int userId;
	private Timestamp insertTime;
	private int isDisable;
	private int voteRight;
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getVoteRight() {
		return voteRight;
	}
	public void setVoteRight(int voteRight) {
		this.voteRight = voteRight;
	}
	public int getIsDisable() {
		return isDisable;
	}
	public void setIsDisable(int isDisable) {
		this.isDisable = isDisable;
	}
	public Timestamp getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Timestamp insertTime) {
		this.insertTime = insertTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVoteAdminId() {
		return voteAdminId;
	}
	public void setVoteAdminId(int voteAdminId) {
		this.voteAdminId = voteAdminId;
	}
	
	
}
