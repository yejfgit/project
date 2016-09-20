package com.ulic.ulweb.ulweb.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.ulweb.dao.UtilDAO;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.entity.UlDocumentModel;
import com.ulic.ulweb.ulweb.service.UtilService;

public class UtilServiceImpl implements UtilService{

	UtilDAO utilDAO;  
	
	
	public UtilDAO getUtilDAO() {
		return utilDAO;
	}

	public void setUtilDAO(UtilDAO utilDAO) {
		this.utilDAO = utilDAO;
	}

	public List getConfigList() throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.getConfigList();
	}

	public int updateConfig(UlConfig c) throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.updateConfig(c);
	}

	public void add(UlConfig c) throws Exception {
		// TODO Auto-generated method stub
		utilDAO.add(c);
	}

	public UlConfig getById(int id) throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.getById(id);
	}

	public List getDocumentModelList() throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.getDocumentModelList();
	}

	public UlDocumentModel getDocumentModelById(int id) throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.getDocumentModelById(id);
	}

	public int editDocumentModle(UlDocumentModel d) throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.editDocumentModle(d);
	}

	public void addDocumentModel(UlDocumentModel d) throws Exception {
		// TODO Auto-generated method stub
		utilDAO.addDocumentModel(d);
	}

	public UlConfig getByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return utilDAO.getByName(name);
	}

	public int getCountProcesser(String dept) throws SQLException {
		// TODO Auto-generated method stub
		return utilDAO.getCountProcesser(dept);
	}

}
