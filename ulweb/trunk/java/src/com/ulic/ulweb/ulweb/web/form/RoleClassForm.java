package com.ulic.ulweb.ulweb.web.form;

import java.util.List;

import org.apache.struts.validator.ValidatorForm;

public class RoleClassForm extends ValidatorForm{

	private int roleClass;
	private String roleName;
//	private List columnId;
	private int roleId;
	private int isAdmin;
	private int adminId;
	private int adminRight;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getAdminRight() {
		return adminRight;
	}
	public void setAdminRight(int adminRight) {
		this.adminRight = adminRight;
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
