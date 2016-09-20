package com.survey.vo;

import java.math.BigDecimal;


public class Option implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private int seq;

	private BigDecimal score;

	private int questionId;
	
	private int countNum;
	
	private BigDecimal percent;
	
	private BigDecimal tdWidth;

	


	public BigDecimal getTdWidth() {
		return tdWidth;
	}

	public void setTdWidth(BigDecimal tdWidth) {
		this.tdWidth = tdWidth;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public int getCountNum() {
		return countNum;
	}

	public void setCountNum(int countNum) {
		this.countNum = countNum;
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

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}