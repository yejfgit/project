package com.ulic.ulweb.ulweb.service.impl;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlVoteQuestionDAO;
import com.ulic.ulweb.ulweb.entity.UlVoteQuestion;
import com.ulic.ulweb.ulweb.service.IUlVoteQuestionService;

public class UlVoteQuestionServiceImpl extends BaseService implements IUlVoteQuestionService{

	private UlVoteQuestionDAO voteQuestionDAO = new UlVoteQuestionDAO();
	
	public void addVoteQuestion(UlVoteQuestion uvq) throws Exception {
		// TODO Auto-generated method stub
		voteQuestionDAO.add(uvq);
	}

	public void deleteVoteQuestion(int id) throws Exception {
		// TODO Auto-generated method stub
		voteQuestionDAO.delete(id);
	}

	public void updateVoteQuestion(UlVoteQuestion uvq) throws Exception {
		// TODO Auto-generated method stub
		voteQuestionDAO.update(uvq);
	}

	public UlVoteQuestion getUlVoteQuestionById(int id) throws Exception {
		// TODO Auto-generated method stub
		return voteQuestionDAO.getById(id);
	}

	public UlVoteQuestionDAO getVoteQuestionDAO() {
		return voteQuestionDAO;
	}

	public void setVoteQuestionDAO(UlVoteQuestionDAO voteQuestionDAO) {
		this.voteQuestionDAO = voteQuestionDAO;
	}



}
