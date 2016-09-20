package com.survey.vo;


public class Dept implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String deptName;

	private int parentId;

	private String deptFullName;

	private int deptLevel;

	private int isDisplay;

	public String getDeptFullName() {
		return deptFullName;
	}

	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}

	public int getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(int deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getIsDisplay() {
		return isDisplay;
	}

	public void setIsDisplay(int isDisplay) {
		this.isDisplay = isDisplay;
	}



}