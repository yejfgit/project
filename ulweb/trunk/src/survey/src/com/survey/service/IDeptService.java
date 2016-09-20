package com.survey.service;

import java.util.List;
import java.util.Map;

import com.survey.vo.Dept;

public interface IDeptService {

	/**
	 * 根据ID得到一个组织
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int id);

	/**
	 * 根据父级ID得到组织列表，和父级组织信息
	 * @param parentId
	 * @return
	 */
	public Map findDeptByParentId(int parentId, int userId);

	/**
	 * 查找所有的组织架构树列表
	 * @return
	 */
	public List<Dept> findTree();
	
	/**
	 * 查找所有分公司（包括总公司）
	 * @return
	 */
	public List<Dept> findBranch();
	
	public List getDept();
	
	public List getUsersByDeptId(int deptId);
	
}


