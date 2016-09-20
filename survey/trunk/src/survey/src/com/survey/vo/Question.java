package com.survey.vo;

import java.math.BigDecimal;
import java.util.List;


public class Question implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private int seq;

	private int surveyId;

	private int type;
	
	//题目所含分数
	private BigDecimal score;
	
	private String typeName;

	private List optionList;
	
	private int maxCheck;
	
	private int minCheck;
	
	private int objSeq;

	
	public int getObjSeq() {
		return objSeq;
	}

	public void setObjSeq(int objSeq) {
		this.objSeq = objSeq;
	}

	public int getMaxCheck() {
		return maxCheck;
	}

	public void setMaxCheck(int maxCheck) {
		this.maxCheck = maxCheck;
	}

	public int getMinCheck() {
		return minCheck;
	}

	public void setMinCheck(int minCheck) {
		this.minCheck = minCheck;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public List getOptionList() {
		return optionList;
	}

	public void setOptionList(List optionList) {
		this.optionList = optionList;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}



	
	

}