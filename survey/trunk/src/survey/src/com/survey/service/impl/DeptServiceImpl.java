package com.survey.service.impl;

import java.util.List;
import java.util.Map;

import com.survey.dao.IBaseDao;
import com.survey.dao.IDeptDao;
import com.survey.dao.impl.BaseDao;
import com.survey.vo.Dept;
import com.survey.vo.TUmOrgan;
import com.survey.service.IDeptService;


public class DeptServiceImpl implements IDeptService {  
	
	private IDeptDao deptDao;
	
	private BaseDao baseDao;
	
	private IBaseDao baseDaoImpl;
	
	
	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

	public List getDept() {
		
		return deptDao.getDept();
	}
	

    public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List getUsersByDeptId(int deptId){
  
    	return deptDao.getUsersByDeptId(deptId);
    }

	public List<Dept> findBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map findDeptByParentId(int parentId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> findTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dept getDeptById(int id) {
		return deptDao.getDeptById(id);
	}

	public List getUmOrganTreeChildsByParentId(String parentId) {
		// TODO Auto-generated method stub
		String sql = "select t.um_organ_id id,t.parent_id parentId,t.full_name fullName,t.abbr_name deptName " +
		"from t_um_organ t " +
		"where t.status = 'Y' " +
		"and t.parent_id = " +parentId+
		"order by t.full_name asc "
		;

		return baseDaoImpl.getList(sql, Dept.class);
	}

	public TUmOrgan getUmOrganById(int deptId) {
		// TODO Auto-generated method stub
		return deptDao.getOrganById(deptId); 
	}

	public List getTSvUsersByDeptId(int deptId) {
		// TODO Auto-generated method stub
		return deptDao.getTSvUsersByDeptId(deptId);
	}

	public List getCompany() {
		// TODO Auto-generated method stub
		String sql = "select t.um_organ_id umOrganId,t.abbr_name abbrName,t.um_org_code umOrgCode "+
					"from t_um_organ t where t.parent_id = 21 and t.org_level in (1,2) "+
					"order by t.um_organ_id asc";
		
		List list = baseDaoImpl.getList(sql, TUmOrgan.class);
		return list;
	}





		

	
	
}
