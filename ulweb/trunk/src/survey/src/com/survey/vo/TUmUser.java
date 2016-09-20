package com.survey.vo;

import java.util.Date;

/**
 * TUmUser generated by MyEclipse Persistence Tools
 */

public class TUmUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String umUserId;

	private String userName;

	private String password;

	private String realName;

	private Date birthday;

	private String gender;

	private Integer certiType;

	private String certiNo;

	private Integer userType;

	private String umOrgan;

	private String isActivie;

	private String disableCause;

	private Date createDate;

	private Date updateDate;
	
	private String mail;


	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUmUserId() {
		return this.umUserId;
	}

	public void setUmUserId(String umUserId) {
		this.umUserId = umUserId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCertiType() {
		return this.certiType;
	}

	public void setCertiType(Integer certiType) {
		this.certiType = certiType;
	}

	public String getCertiNo() {
		return this.certiNo;
	}

	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUmOrgan() {
		return this.umOrgan;
	}

	public void setUmOrgan(String umOrgan) {
		this.umOrgan = umOrgan;
	}

	public String getIsActivie() {
		return this.isActivie;
	}

	public void setIsActivie(String isActivie) {
		this.isActivie = isActivie;
	}

	public String getDisableCause() {
		return this.disableCause;
	}

	public void setDisableCause(String disableCause) {
		this.disableCause = disableCause;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}