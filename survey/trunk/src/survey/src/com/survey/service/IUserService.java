package com.survey.service;

import java.util.List;

import com.survey.vo.DispatchUser;
import com.survey.vo.TUmUser;
import com.survey.vo.User;
import com.survey.vo.UserContextVO;

public interface IUserService {
	
	public TUmUser getUmUserByUserId(int userId);
	
	public TUmUser getUmUserByUserName(String userName);
	
	public User getUserById(int id);

	public User getUserByUserName(String name);
	
	public User getByUserName(String name);
	
	public TUmUser saveUmUser(String userName, String mail);

	public List getUserListByUserNameOrRealName(String userName);
	
	/**
	 * 登录处理
	 * 成功返回true，失败返回false
	 * @param userName
	 * @param remoteAddress
	 * @return UserContext
	 */
	public UserContextVO login(String userName, String remoteAddress);
	
	/**
	 * 根据umUserId获得用户全部信息
	 * @param userId
	 * @return
	 */
	public DispatchUser getDispatchUserByUmUserId(int userId);
	
	/**
	 * 根据用户名或用户真实姓名获取用户信息
	 * @param userName
	 * @return
	 */
	public List getDisPatchUserListByUserNameOrRealName(String userName);
	
	/**
	 * 根据岗位选择用户
	 * @param positionName
	 * @return
	 */
	public List getTSvUsersByPositionName(String positionName,int organId);
	

	}
