package com.ulic.ulweb.ulweb.service;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlVote;


public interface IUlVoteService extends IService{
	public void addVote(UlVote uv) throws Exception;
	public void deleteVote(int id) throws Exception;
	public void updateVote(UlVote uv) throws Exception;
	public UlVote getUlVoteById(int id) throws Exception;
}
