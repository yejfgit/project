package com.ulic.ulweb.ulweb2.service.impl;

import java.util.Iterator;
import java.util.List;

import com.ulic.ulweb.ulweb2.dao.IDeptDao;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;
import com.ulic.ulweb.ulweb2.service.IDeptService;

public class DeptService implements IDeptService {
	private IDeptDao deptDao;
	
	private IContentTmplService contentTmplService;

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	public void setContentTmplService(IContentTmplService contentTmplService) {
		this.contentTmplService = contentTmplService;
	}

	public List getAllDepts(boolean withContentTmpl) {

		//System.out.println("DeptService.getAllDepts()");
		List l = deptDao.findAll();
		if (!withContentTmpl) {
			return l;
		}
		
		Iterator iter = l.iterator();
		while (iter.hasNext()) {
			DeptEntity d = (DeptEntity) iter.next();
			ContentTmplEntity ct = contentTmplService.getTmplById(
					d.getContentTmplId());
			if (ct == null) {
				d.setContentTmplId(0);
			} else {
				d.setContentTmplName(ct.getTmplName());
			}
		}
		return l;
	}

	public DeptEntity getDeptById(String id) {

		return deptDao.getById(id);
	}

	public boolean delDeptById(String id) {

		DeptEntity d = deptDao.getById(id);
		if (d == null) {
			return false;
		} else {
			return deptDao.delete(d);
		}
		
	}

	public boolean saveDept(DeptEntity d) {

		return deptDao.save(d);
	}

	public boolean updateDept(DeptEntity d) {

		return deptDao.update(d);
	}


}
