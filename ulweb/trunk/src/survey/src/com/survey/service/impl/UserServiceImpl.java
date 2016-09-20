package com.survey.service.impl;

import java.util.Date;
import java.util.List;

import com.survey.dao.ISurveyDao;
import com.survey.dao.IUserDao;
import com.survey.dao.impl.BaseDao;
import com.survey.service.IUserService;
import com.survey.vo.TUmUser;
import com.survey.vo.User;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;
	
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public TUmUser getUmUserByUserId(int userId) {
		return this.userDao.getUmUserByUserId(userId);
	}
	
	public TUmUser getUmUserByUserName(String userName){
		return this.userDao.getUmUserByUserName(userName);
	}
	
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	public User getByUserName(String name){
		return this.userDao.getByUserName(name);
	}

	public User getUserByUserName(String name) {
		return this.userDao.getUserByUserName(name);
	}

	public TUmUser saveUmUser(String userName, String mail) {
		

		
		TUmUser u = new TUmUser();
		u.setUserName(mail.substring(0, mail.indexOf("@")));
		u.setRealName(userName);
		u.setMail(mail);
		u.setUmOrgan("900001");
		u.setUserType(0);
		u.setIsActivie("Y");
		u.setCreateDate(new Date());
		u.setUpdateDate(new Date());
		u = (TUmUser) baseDao.save(u);
		
		return u;
	}
}
