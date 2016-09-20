package com.survey.vo;

import java.util.Date;


public class DispatchUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String empId;

	private String empName;

	private int deptId;

	private String abbrName;

	private String deptName;
	
	private int positionId;
	
	private String positionName;

	private int rank;
	
	private String rankName;
	
	private String rankCode;
	
	private String workEmail;
	
	private Date updateTime;
	
	private String umUserId;
	
	private String umOrgan;
	
	private String realName;
	
	private String userName;
	
	private String deptFullName;
	


	public String getDeptFullName() {
		return deptFullName;
	}

	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUmOrgan() {
		return umOrgan;
	}

	public void setUmOrgan(String umOrgan) {
		this.umOrgan = umOrgan;
	}

	public String getUmUserId() {
		return umUserId;
	}

	public void setUmUserId(String umUserId) {
		this.umUserId = umUserId;
	}

	public String getAbbrName() {
		return abbrName;
	}

	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRankCode() {
		return rankCode;
	}

	public void setRankCode(String rankCode) {
		this.rankCode = rankCode;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
	
	

}	