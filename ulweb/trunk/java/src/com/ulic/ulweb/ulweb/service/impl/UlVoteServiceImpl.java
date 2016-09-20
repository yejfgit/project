package com.ulic.ulweb.ulweb.service.impl;

import com.ulic.ulweb.frame.service.BaseService;

import com.ulic.ulweb.ulweb.dao.UlVoteDAO;
import com.ulic.ulweb.ulweb.entity.UlVote;
import com.ulic.ulweb.ulweb.service.IUlVoteService;

public class UlVoteServiceImpl extends BaseService implements IUlVoteService{
	private UlVoteDAO voteDAO = new UlVoteDAO();
	
	public void addVote(UlVote uv) throws Exception {
		// TODO Auto-generated method stub
		voteDAO.create(uv);
	}

	public void deleteVote(int id) throws Exception {
		// TODO Auto-generated method stub
		voteDAO.delete(id);
	}

	public UlVoteDAO getVoteDAO() {
		return voteDAO;
	}

	public void setVoteDAO(UlVoteDAO voteDAO) {
		this.voteDAO = voteDAO;
	}

	public void updateVote(UlVote uv) throws Exception {
		// TODO Auto-generated method stub
		voteDAO.update(uv);
	}

	public UlVote getUlVoteById(int id) throws Exception {
		// TODO Auto-generated method stub
		return voteDAO.getById(id);
	}

}
