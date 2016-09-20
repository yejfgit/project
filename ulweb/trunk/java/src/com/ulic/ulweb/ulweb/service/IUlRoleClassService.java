package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;


public interface IUlRoleClassService extends IService{
	public void addRoleClass(UlRoleClass urc) throws Exception;
	public void deleteRoleClass(int id) throws Exception;
	public void updateRoleClass(UlRoleClass urc) throws Exception;
	public UlRoleClass getUlRoleClassById(int id) throws Exception;
	public int getUserRoleMaxClass(String userRoleList) throws Exception;
	public int getUserAdminClass(String userRoleList) throws Exception;
	public String getUserRightColumn(String strUserRoleList) throws Exception;
	public String getUserRightColumn(int roleId) throws Exception;
	public List getRoleList() throws Exception;
	public String getUserDept(int roleId) throws Exception;
	
}
