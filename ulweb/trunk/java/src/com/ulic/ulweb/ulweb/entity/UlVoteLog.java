package com.ulic.ulweb.ulweb.entity;

import java.sql.Timestamp;
import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlVoteLog extends AbstractBean{

	private int votelogId;
	private int voteId;
	private String ip;
	private String voteUserName;
	private Timestamp voteTime;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getVoteId() {
		return voteId;
	}
	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}
	public int getVotelogId() {
		return votelogId;
	}
	public void setVotelogId(int votelogId) {
		this.votelogId = votelogId;
	}
	public Timestamp getVoteTime() {
		return voteTime;
	}
	public void setVoteTime(Timestamp voteTime) {
		this.voteTime = voteTime;
	}
	public String getVoteUserName() {
		return voteUserName;
	}
	public void setVoteUserName(String voteUserName) {
		this.voteUserName = voteUserName;
	}
	
	
}
