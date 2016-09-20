package com.ulic.ulweb.ulweb.entity;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlDept extends AbstractBean{

	private String deptId;
	private String deptName;
	private int deptModel;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public int getDeptModel() {
		return deptModel;
	}
	public void setDeptModel(int deptModel) {
		this.deptModel = deptModel;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
