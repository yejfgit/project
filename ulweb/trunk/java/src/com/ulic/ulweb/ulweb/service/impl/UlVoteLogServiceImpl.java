package com.ulic.ulweb.ulweb.service.impl;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlVoteLogDAO;
import com.ulic.ulweb.ulweb.entity.UlVoteLog;
import com.ulic.ulweb.ulweb.service.IUlVoteLogService;

public class UlVoteLogServiceImpl extends BaseService implements IUlVoteLogService{

	private UlVoteLogDAO voteLogDAO = new UlVoteLogDAO();
	
	public void addVoteLog(UlVoteLog uvl) throws Exception {
		// TODO Auto-generated method stub
		voteLogDAO.add(uvl);
	}

	public void deleteVoteLog(int id) throws Exception {
		// TODO Auto-generated method stub
		voteLogDAO.delete(id);
	}

	public void updateVoteLog(UlVoteLog uvl) throws Exception {
		// TODO Auto-generated method stub
		voteLogDAO.update(uvl);
	}

	public UlVoteLog getUlVoteLogById(int id) throws Exception {
		// TODO Auto-generated method stub
		return voteLogDAO.getById(id);
	}

	public UlVoteLogDAO getVoteLogDAO() {
		return voteLogDAO;
	}

	public void setVoteLogDAO(UlVoteLogDAO voteLogDAO) {
		this.voteLogDAO = voteLogDAO;
	}

	

}
