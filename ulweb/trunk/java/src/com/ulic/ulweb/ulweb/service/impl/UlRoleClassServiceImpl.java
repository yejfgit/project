package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlRoleClassDAO;
import com.ulic.ulweb.ulweb.entity.UlRoleClass;
import com.ulic.ulweb.ulweb.service.IUlRoleClassService;

public class UlRoleClassServiceImpl extends BaseService implements IUlRoleClassService{

	private UlRoleClassDAO roleClassDAO = new UlRoleClassDAO();

	

	public UlRoleClassDAO getRoleClassDAO() {
		return roleClassDAO;
	}

	public void setRoleClassDAO(UlRoleClassDAO roleClassDAO) {
		this.roleClassDAO = roleClassDAO;
	}

	public void addRoleClass(UlRoleClass urc) throws Exception {
		// TODO Auto-generated method stub
		roleClassDAO.create(urc);
	}

	public void deleteRoleClass(int id) throws Exception {
		// TODO Auto-generated method stub
		roleClassDAO.delete(id);
	} 

	public void updateRoleClass(UlRoleClass urc) throws Exception {
		// TODO Auto-generated method stub
		roleClassDAO.update(urc);
	}

	public UlRoleClass getUlRoleClassById(int id) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getById(id);
	}

	public int getUserRoleMaxClass(String userRoleList) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserRoleMaxClass(userRoleList);
	}

	public int getUserAdminClass(String userRoleList) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserAdminClass(userRoleList);
	}

	public String getUserRightColumn(String userRoleList) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserRightColumn(userRoleList);
	}

	public List getRoleList() throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getRoleList();
	}

	public String getUserRightColumn(int roleId) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserRightColumn(roleId);
	}

	public String getUserDept(int roleId) throws Exception {
		// TODO Auto-generated method stub
		return roleClassDAO.getUserDept(roleId);
	}

		
}
