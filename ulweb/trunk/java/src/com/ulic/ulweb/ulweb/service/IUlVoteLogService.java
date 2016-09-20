package com.ulic.ulweb.ulweb.service;

import com.ulic.ulweb.frame.service.IService;

import com.ulic.ulweb.ulweb.entity.UlVoteLog;

public interface IUlVoteLogService extends IService{
	public void addVoteLog(UlVoteLog uvl) throws Exception;
	public void deleteVoteLog(int id) throws Exception;
	public void updateVoteLog(UlVoteLog uvl) throws Exception;
	public UlVoteLog getUlVoteLogById(int id) throws Exception;
}
