package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlVoteAdmin;

public interface IUlVoteAdminService extends IService{
	public void addVoteAdmin(UlVoteAdmin uva) throws Exception;
	public void deleteVoteAdmin(int id) throws Exception;
	public void updateVoteAdmin(UlVoteAdmin uva) throws Exception;
	public UlVoteAdmin getUlVoteAdminById(int id) throws Exception;
	public List getUserList() throws Exception; 
	public UlVoteAdmin getByUserId(int userId) throws Exception;
	public void setDisable(int id) throws Exception;
	
}
