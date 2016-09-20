package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlDept;

public interface IUlDeptService extends IService {
	public void save(UlDept dept) throws Exception;
	public void delete(String id) throws Exception;
	public List getList() throws Exception;
	public int update(UlDept dept) throws Exception;
	public UlDept getDept(String id) throws Exception;
}
