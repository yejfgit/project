package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlChat;

public interface IUlChatService extends IService {
	public void  save(UlChat c) throws Exception;
	public List getChathis(int page, int pageSize) throws Exception;
}
