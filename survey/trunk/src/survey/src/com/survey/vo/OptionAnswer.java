package com.survey.vo;

public class OptionAnswer implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int answerId;

	private int optionId;

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

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}


}