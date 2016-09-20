package com.survey.vo;


public class TextAnswer implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int answerId;

	private String text;
	
	private int missionId;
	
	private int surveyId;
	
	private String realName;
	
	private String fullName;
	
	private String questionName;
	
	private int isRead;
	
	private int score;

	public int getIsRead() {
		return isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}