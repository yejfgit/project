package com.survey.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class Mission implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int userId;

	private int surveyId;
	
	private int isClosed;

	private Date requestTime;

	private Date beginTime;

	private Date finishTime;

	private int totalScore;
	
	private Survey survey;
	
	private List answerList;
	
	private int deptId;
	
	private int hurryTimes;
	
	private String errorMsg;
	
	private int isTiming;
	
	private int timeLimit;
	
	private int unFinishNum;
	
	private int finishNum;
	
	private int closeNum;
	
	private int allNum;
	

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getCloseNum() {
		return closeNum;
	}

	public void setCloseNum(int closeNum) {
		this.closeNum = closeNum;
	}

	public int getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(int finishNum) {
		this.finishNum = finishNum;
	}

	public int getUnFinishNum() {
		return unFinishNum;
	}

	public void setUnFinishNum(int unFinishNum) {
		this.unFinishNum = unFinishNum;
	}

	public int getIsTiming() {
		return isTiming;
	}

	public void setIsTiming(int isTiming) {
		this.isTiming = isTiming;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getHurryTimes() {
		return hurryTimes;
	}

	public void setHurryTimes(int hurryTimes) {
		this.hurryTimes = hurryTimes;
	}

	public List getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List answerList) {
		this.answerList = answerList;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}


}