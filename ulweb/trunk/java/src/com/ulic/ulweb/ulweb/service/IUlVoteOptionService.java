package com.ulic.ulweb.ulweb.service;

import com.ulic.ulweb.frame.service.IService;

import com.ulic.ulweb.ulweb.entity.UlVoteOption;

public interface IUlVoteOptionService extends IService{
	public void addVoteOption(UlVoteOption uvo) throws Exception;
	public void deleteVoteOption(int id) throws Exception;
	public void updateVoteOption(UlVoteOption uvo) throws Exception;
	public UlVoteOption getUlVoteOptionById(int id) throws Exception;
}
