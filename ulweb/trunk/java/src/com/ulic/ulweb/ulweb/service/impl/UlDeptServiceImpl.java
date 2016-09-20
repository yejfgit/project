package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.ulweb.dao.UlDeptDAO;
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.service.IUlDeptService;

public class UlDeptServiceImpl implements IUlDeptService{
	private UlDeptDAO deptDAO = new UlDeptDAO();

	public void save(UlDept dept) throws Exception {
		// TODO Auto-generated method stub
		deptDAO.create(dept);
	}

	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		deptDAO.delete(id);
	}

	public List getList() throws Exception {
		// TODO Auto-generated method stub
		return deptDAO.getList();
	}

	public int update(UlDept dept) throws Exception {
		// TODO Auto-generated method stub
		return deptDAO.update(dept);
	}

	public UlDeptDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(UlDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	public UlDept getDept(String id) throws Exception {
		// TODO Auto-generated method stub
		return this.deptDAO.getDept(id);
	}
	

}
