package com.survey.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import com.survey.vo.User;

public class UserContextVO  implements Serializable {
//	Log log = LogFactory.getLog(UserContextVO.class);
	private int userId;
	private String userName;
	private String realName;
	private String email;
	private String mobile;
	private int sendMailType;
	private int defaultApprove;
	private int toaDeptId;
	private String adminName;
	private String deptName;	
	private String deptFullName;
	private Date modifyPasswordDate;
	private String userIp;
	
	private String roleName;
	private User user;
	
	
	/*
	 * 登录用户的信息
	 * loginStatus:0 未登录  1 成功登录  2 登录失败
	 * loginInfo: 记录详细中文说明
	 */
	private int loginStatus;
	private String loginInfo;
	
	
	/*
	 * 权限
	 */
//	private Set<TOaRight> right;
//
//
//
//
//	
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//
//	public boolean checkRight(String rightName){
//		/*
//		 * 检测用户权限，输入权限名
//		 * 如果存在并且权限可用，则返回true
//		 */
//		try{
//			Iterator iterator = this.getRight().iterator();
//			while(iterator.hasNext()){
//				TOaRight r = (TOaRight)iterator.next();
//				//System.out.println("----------user right:" + r.getRightName());
//				if(r.getRightName().equals(rightName) && r.getIsEffective() == 1) return true;
//				
//			}
//		}catch(Exception e){
//			
//			return false;
//		}
//			
//		return false;
//	}
	
	
	
	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public int getDefaultApprove() {
		return defaultApprove;
	}


	public void setDefaultApprove(int defaultApprove) {
		this.defaultApprove = defaultApprove;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDeptFullName() {
		return deptFullName;
	}


	public void setDeptFullName(String deptFullName) {
		this.deptFullName = deptFullName;
	}


//	public Set<TOaRight> getRight() {
//		return right;
//	}
//
//
//	public void setRight(Set<TOaRight> right) {
//		this.right = right;
//	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	


	public int getSendMailType() {
		return sendMailType;
	}


	public void setSendMailType(int sendMailType) {
		this.sendMailType = sendMailType;
	}


	public int getToaDeptId() {
		return toaDeptId;
	}


	public void setToaDeptId(int toaDeptId) {
		this.toaDeptId = toaDeptId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	private int respId = -1;	//ְ
	private int moduleId = -1;  //Ȩ��ģ��ID
	
	public int getRespId() {
		return respId;
	}

	public void setRespId(int respId) {
		this.respId = respId;
	}
	
	public int getModuleId() {
		return moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}


	public String getLoginInfo() {
		return loginInfo;
	}


	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}


	public int getLoginStatus() {
		return loginStatus;
	}


	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getModifyPasswordDate() {
		return modifyPasswordDate;
	}

	public void setModifyPasswordDate(Date modifyPasswordDate) {
		this.modifyPasswordDate = modifyPasswordDate;
	}


	public String getUserIp() {
		return userIp;
	}


	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}


	public User getUser() {
		return this.user;
	}


	public void setUser(User vo) {
		this.user = vo;
		
	}

	
}
