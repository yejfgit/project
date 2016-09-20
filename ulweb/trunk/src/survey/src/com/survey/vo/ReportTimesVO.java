package com.survey.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class ReportTimesVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String surveyName;
	
	private String userRealName;
	
	private String deptFullName;

	private Date requestTime;

	private Date beginTime;

	private Date finishTime;

	private BigDecimal totalScore;
	
//	private int score;
	
	private Survey survey;
	
	private List answerList;
	
	

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


	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}


	public String getDeptFullName() {
		return deptFullName;
	}

	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}



	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}


}