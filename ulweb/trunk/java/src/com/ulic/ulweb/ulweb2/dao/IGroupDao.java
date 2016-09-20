package com.ulic.ulweb.ulweb2.dao;

import java.util.List;

import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;

public interface IGroupDao {

	/**
	 * 根据组名，查询组信息
	 * @param type
	 * @return
	 * @author linda.hou
	 * @date 2010-5-7 上午10:44:23
	 */
	public List<CusEdcprincipalentitytype> listGroupByType(String type);
	
	/**
	 * 获取所有的组信息
	 * @return
	 * @author linda.hou
	 * @date 2010-5-12 下午03:30:29
	 */
	public List<CusEdcprincipalentitytype> listAllGroup();
	
	/**
	 * 根据用户登录名查询用户列表
	 * @param uidString
	 * @return
	 * @author linda.hou
	 * @date 2010-5-7 上午10:44:01
	 */
	public List<Edcprincipaluserentity> findUsers(String uidString);
	
	/**
	 * 根据uidString 查询相应的用户信息
	 * @param uidString
	 * @return
	 */
	public Edcprincipaluserentity getUserBuId(String uidString);
}
