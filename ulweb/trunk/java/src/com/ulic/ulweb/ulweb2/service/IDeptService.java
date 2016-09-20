package com.ulic.ulweb.ulweb2.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;

public interface IDeptService extends IService {

	List getAllDepts(boolean withContentTmpl);

	DeptEntity getDeptById(String id);

	boolean delDeptById(String id);

	boolean saveDept(DeptEntity d);

	boolean updateDept(DeptEntity d);

}
