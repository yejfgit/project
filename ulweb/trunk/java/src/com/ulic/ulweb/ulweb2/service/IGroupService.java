package com.ulic.ulweb.ulweb2.service;

import java.util.List;

import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;

public interface IGroupService {

	/**
	 * 根据类型信息获取相应组集合
	 * @param type
	 * @return
	 * @author linda.hou
	 * @date 2010-5-12 下午03:29:05
	 */
	public List<CusEdcprincipalentitytype> listGroupByType(String type) ;
	
	public List<CusEdcprincipalentitytype> listAllGroup();
	
	/**
	 * 根据用户登录名查询用户列表
	 * @param uidString
	 * @return
	 * @author linda.hou
	 * @date 2010-5-7 上午10:56:29
	 */
	public List<Edcprincipaluserentity> findUsers(String uidString);
	
	public Edcprincipaluserentity getUserById(String uidString);
	
	
}
