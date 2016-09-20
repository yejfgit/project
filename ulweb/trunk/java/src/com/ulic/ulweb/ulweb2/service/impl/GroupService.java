package com.ulic.ulweb.ulweb2.service.impl;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.dao.IGroupDao;
import com.ulic.ulweb.ulweb2.dao.impl.GroupDao;
import com.ulic.ulweb.ulweb2.entity.CusEdcprincipalentitytype;
import com.ulic.ulweb.ulweb2.entity.Edcprincipaluserentity;
import com.ulic.ulweb.ulweb2.service.IGroupService;

public class GroupService implements IService, IGroupService {
	
	IGroupDao groupDao = null;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	
	public List<CusEdcprincipalentitytype> listGroupByType(String type) {
		 return groupDao.listGroupByType(type);
	}

	public List<CusEdcprincipalentitytype> listAllGroup() {
		return groupDao.listAllGroup();
	}

	public List<Edcprincipaluserentity> findUsers(String uidString) {
		return groupDao.findUsers(uidString);
	}

	public Edcprincipaluserentity getUserById(String uidString) {
		 
		return groupDao.getUserBuId(uidString);
	}

	

	
}
