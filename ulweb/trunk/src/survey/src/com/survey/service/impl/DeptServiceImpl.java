package com.survey.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.survey.dao.IDeptDao;
import com.survey.dao.ISurveyDao;
import com.survey.vo.Dept;
import com.survey.vo.TUmOrgan;
import com.survey.service.IDeptService;


public class DeptServiceImpl implements IDeptService {
	
	private IDeptDao deptDao;
	
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public List getDept() {
		
		return deptDao.getDept();
	}

    public List getUsersByDeptId(int deptId){
  
    	return deptDao.getUsersByDeptId(deptId);
    }

	public List<Dept> findBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map findDeptByParentId(int parentId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> findTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dept getDeptById(int id) {
		return deptDao.getDeptById(id);
	}





		

	
	
}
