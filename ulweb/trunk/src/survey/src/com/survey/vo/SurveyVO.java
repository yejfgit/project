package com.survey.vo;

import java.util.List;


public class SurveyVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int surveyId;

	private String surveyName;

	private int ownerId;
	
	private List questionList;
	
	private int questionSeq;
	
	private String questionName;
	
	private int isYes;
	
	private int isNo;
	
	private int totalYes;
	
	private int totalNo;
	
	private int score;
	
	private String tips;
	

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public List getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List questionList) {
		this.questionList = questionList;
	}


	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public int getQuestionSeq() {
		return questionSeq;
	}

	public void setQuestionSeq(int questionSeq) {
		this.questionSeq = questionSeq;
	}

	public int getIsNo() {
		return isNo;
	}

	public void setIsNo(int isNo) {
		this.isNo = isNo;
	}

	public int getIsYes() {
		return isYes;
	}

	public void setIsYes(int isYes) {
		this.isYes = isYes;
	}

	public int getTotalNo() {
		return totalNo;
	}

	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}

	public int getTotalYes() {
		return totalYes;
	}

	public void setTotalYes(int totalYes) {
		this.totalYes = totalYes;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}