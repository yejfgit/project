package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlVoteAdminDAO;
import com.ulic.ulweb.ulweb.entity.UlVoteAdmin;
import com.ulic.ulweb.ulweb.service.IUlVoteAdminService;

public class UlVoteAdminServiceImpl extends BaseService implements IUlVoteAdminService{

	
	private UlVoteAdminDAO voteAdminDAO = new UlVoteAdminDAO();
	
	public void addVoteAdmin(UlVoteAdmin uva) throws Exception {
		// TODO Auto-generated method stub
		voteAdminDAO.add(uva);
	}

	public void deleteVoteAdmin(int id) throws Exception {
		// TODO Auto-generated method stub
		voteAdminDAO.delete(id);
	}

	public void updateVoteAdmin(UlVoteAdmin uva) throws Exception {
		// TODO Auto-generated method stub
		voteAdminDAO.update(uva);
	}

	public UlVoteAdmin getUlVoteAdminById(int id) throws Exception {
		// TODO Auto-generated method stub
		return voteAdminDAO.getById(id);
	}

	public UlVoteAdminDAO getVoteAdminDAO() {
		return voteAdminDAO;
	}

	public void setVoteAdminDAO(UlVoteAdminDAO voteAdminDAO) {
		this.voteAdminDAO = voteAdminDAO;
	}

	public List getUserList() throws Exception {
		// TODO Auto-generated method stub
		return voteAdminDAO.getUserList();
	}

	public UlVoteAdmin getByUserId(int userId) throws Exception {
		// TODO Auto-generated method stub
		return voteAdminDAO.getByUserId(userId);
	}

	public void setDisable(int id) throws Exception {
		// TODO Auto-generated method stub
		voteAdminDAO.setDisable(id);
	}


}
