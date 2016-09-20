package com.ulic.ulweb.ulweb.entity;


import java.util.List;

import com.ulic.ulweb.frame.bean.AbstractBean;

public class UlRoleClass extends AbstractBean{
	private int roleId;
	private int roleClass;
	private int isAdmin;
	private String columnId;
	private String name;
	private String dept;
	private int loginOk;
	private String pw;
	private List list;
	
	
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getLoginOk() {
		return loginOk;
	}
	public void setLoginOk(int loginOk) {
		this.loginOk = loginOk;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColumnId() {
		return columnId;
	}
	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getRoleClass() {
		return roleClass;
	}
	public void setRoleClass(int roleClass) {
		this.roleClass = roleClass;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
