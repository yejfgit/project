package com.survey.dao;

import java.util.List;

import com.survey.vo.DispatchUser;
import com.survey.vo.TUmUser;
import com.survey.vo.User;

public interface IUserDao {

	public TUmUser getUmUserByUserId(int userId);

	public TUmUser getUmUserByUserName(String userName);

	public User getUserById(int id);
	
	public User getUserByUserName(String name);
	
	public User getByUserName(String name);
	
	/**
	 * 根据empId获取用户全部信息
	 * @param string
	 * @return
	 */
	public DispatchUser getDispatchUserByEmpId(String string);
	
	/**
	 * 根据umUserId获取用户全部r
	 * @param userId
	 * @return
	 */
	public DispatchUser getDispatchUserByUmUserId(int userId);

}
