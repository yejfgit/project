package com.survey.dao;

import java.util.List;

import com.survey.vo.Dept;
import com.survey.vo.TUmOrgan;

/**
 * 组织架构DAO
 * 
 * @author wengxf
 * 
 */

public interface IDeptDao  {
	
	/**
	 * 根据ID得到一个组织
	 * 
	 * @param id
	 * @return
	 */
	public Dept getDeptById(int id);

		
	/**
	 * 根据父级ID得到组织列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<Dept> findDeptByParentId(int parentId);

	


	public List<Dept> findTree();

	public List<Dept> findBranch();
	
	/**
	 * 根据父级机构ID得到下级所有子机构的ID列表
	 * @param parentId
	 * @return
	 */
	public List<Dept> findTreeByParentId(int parentId);


	public List getDept();
	
	public List getUsersByDeptId(int deptId);


	public TUmOrgan getOrganById(int deptId);

	/**
	 * 根据umOrganId获取相应hr中用户信息
	 * @param deptId
	 * @return
	 */
	public List getTSvUsersByDeptId(int deptId);


}