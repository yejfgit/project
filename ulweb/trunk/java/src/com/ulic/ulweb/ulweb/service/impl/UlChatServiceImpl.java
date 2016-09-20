package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.ulweb.dao.UlChatDAO;
import com.ulic.ulweb.ulweb.entity.UlChat;
import com.ulic.ulweb.ulweb.service.IUlChatService;

public class UlChatServiceImpl implements IUlChatService{
	private UlChatDAO chatDAO = new UlChatDAO(); 
	
	public UlChatDAO getChatDAO() {
		return chatDAO;
	}

	public void setChatDAO(UlChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	public void save(UlChat c) throws Exception {
		// TODO Auto-generated method stub
		chatDAO.save(c);
	}

	public List getChathis(int page, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return chatDAO.getChatHis(page, pageSize);
	}

}
