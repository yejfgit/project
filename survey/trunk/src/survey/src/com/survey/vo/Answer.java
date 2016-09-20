package com.survey.vo;

import java.util.List;



public class Answer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int missionId;

	private int questionId;
	
	private List optionAnswerList;
	

	public List getOptionAnswerList() {
		return optionAnswerList;
	}

	public void setOptionAnswerList(List optionAnswerList) {
		this.optionAnswerList = optionAnswerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMissionId() {
		return missionId;
	}

	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}