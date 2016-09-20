package com.survey.vo;

import java.util.List;


public class Survey implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private int ownerId;
	
	private int timeLimit;
	
	private int isShuffle;
	
	private List questionList;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getIsShuffle() {
		return isShuffle;
	}

	public void setIsShuffle(int isShuffle) {
		this.isShuffle = isShuffle;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

}