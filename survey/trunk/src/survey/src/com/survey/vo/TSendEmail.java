package com.survey.vo;

import java.util.Date;


public class TSendEmail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private int surveyId;
	
	private String email;
	
	private int ifSend;
	
	private int sendType;
	
	private int ifCopySend;
	
	private String copySendEmail;
	
	private int missionId;
	
	private int userId;
	
	private int fcu;

	private Date fcd;

	private int lcu;

	private Date lcd;

	public String getCopySendEmail() {
		return copySendEmail;
	}

	public void setCopySendEmail(String copySendEmail) {
		this.copySendEmail = copySendEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFcd() {
		return fcd;
	}

	public void setFcd(Date fcd) {
		this.fcd = fcd;
	}

	public int getFcu() {
		return fcu;
	}

	public void setFcu(int fcu) {
		this.fcu = fcu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIfCopySend() {
		return ifCopySend;
	}

	public void setIfCopySend(int ifCopySend) {
		this.ifCopySend = ifCopySend;
	}

	public int getIfSend() {
		return ifSend;
	}

	public void setIfSend(int ifSend) {
		this.ifSend = ifSend;
	}

	public Date getLcd() {
		return lcd;
	}

	public void setLcd(Date lcd) {
		this.lcd = lcd;
	}

	public int getLcu() {
		return lcu;
	}

	public void setLcu(int lcu) {
		this.lcu = lcu;
	}

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	public int getSendType() {
		return sendType;
	}

	public void setSendType(int sendType) {
		this.sendType = sendType;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	

}	