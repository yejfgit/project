package com.survey.vo;


public class TextAnswer implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int answerId;

	private String text;

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