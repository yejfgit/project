package com.ulic.ulweb.ulweb.service.impl;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlVoteOptionDAO;
import com.ulic.ulweb.ulweb.entity.UlVoteOption;
import com.ulic.ulweb.ulweb.service.IUlVoteOptionService;

public class UlVoteOptionServiceImpl extends BaseService implements IUlVoteOptionService{

	private UlVoteOptionDAO voteOptionDAO = new UlVoteOptionDAO();
	
	public void addVoteOption(UlVoteOption uvo) throws Exception {
		// TODO Auto-generated method stub
		voteOptionDAO.add(uvo);
		
	}

	public void deleteVoteOption(int id) throws Exception {
		// TODO Auto-generated method stub
		voteOptionDAO.delete(id);
	}

	public void updateVoteOption(UlVoteOption uvo) throws Exception {
		// TODO Auto-generated method stub
		voteOptionDAO.update(uvo);
	}

	public UlVoteOption getUlVoteOptionById(int id) throws Exception {
		// TODO Auto-generated method stub
		return voteOptionDAO.getById(id);
	}

	public UlVoteOptionDAO getVoteOptionDAO() {
		return voteOptionDAO;
	}

	public void setVoteOptionDAO(UlVoteOptionDAO voteOptionDAO) {
		this.voteOptionDAO = voteOptionDAO;
	}


}
