package com.survey.dao;

import java.util.List;

import com.survey.vo.TUmUser;
import com.survey.vo.User;

public interface IUserDao {

	public TUmUser getUmUserByUserId(int userId);

	public TUmUser getUmUserByUserName(String userName);

	public User getUserById(int id);
	
	public User getUserByUserName(String name);
	
	public User getByUserName(String name);

}
