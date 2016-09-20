package com.ulic.ulweb.ulweb.service;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlVoteQuestion;

public interface IUlVoteQuestionService extends IService{
	public void addVoteQuestion(UlVoteQuestion uvq) throws Exception;
	public void deleteVoteQuestion(int id) throws Exception;
	public void updateVoteQuestion(UlVoteQuestion uvq) throws Exception;
	public UlVoteQuestion getUlVoteQuestionById(int id) throws Exception;
}
