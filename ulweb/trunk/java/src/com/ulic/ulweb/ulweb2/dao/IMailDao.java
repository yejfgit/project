package com.ulic.ulweb.ulweb2.dao;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.MailEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public interface IMailDao extends IService {

	public void save(MailEntity mail);
	public PageEntity listMail(PageEntity pe); 
	
	
	
}
