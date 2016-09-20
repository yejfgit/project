package com.survey.vo;

public class CategoryVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String category;

	private int num;
	
	private int type;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}