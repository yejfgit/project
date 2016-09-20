package com.ulic.ulweb.ulweb.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ulic.ulweb.frame.service.BaseService;
import com.ulic.ulweb.ulweb.dao.UlColumnDAO;
import com.ulic.ulweb.ulweb.entity.UlColumn;
import com.ulic.ulweb.ulweb.entity.UlDept;
import com.ulic.ulweb.ulweb.service.IUlColumnService;

public class UlColumnServiceImpl extends BaseService implements IUlColumnService{

	private UlColumnDAO columnDAO = new UlColumnDAO(); 
	
	

	public UlColumnDAO getColumnDAO() {
		return columnDAO;
	}

	public void setColumnDAO(UlColumnDAO columnDAO) {
		this.columnDAO = columnDAO;
	}

	public void addColumn(UlColumn UlColumn) throws Exception {
		// TODO Auto-generated method stub
		columnDAO.create(UlColumn);
	}

	public String deleteColumn(int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.delete(id);
	}

	public void updateColumn(UlColumn uc) throws Exception {
		// TODO Auto-generated method stub
		columnDAO.update(uc);
	}

	public UlColumn getColumnById(int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getById(id);
	}

	public List getColumnsByParentId(int id, String dept) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByParentId(id,dept);
	}

	public List getListWOrganClassByParentId(int oClass, int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListWOrganClassByParentId(id, oClass);
	}

	public List getListWOtherClassByParentId(int oClass, int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListWOtherClassByParentId(id, oClass);
	}

	public List getListByChackKeyword(String ids, String keyWord) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListWCheckByKeyword(ids, keyWord);
	}

	public List getListByColumnIds(String ids) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByColumnIds(ids);
	}

	public List getListByColumnLevelAndDept(int level, String deptid, int showToUser) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByColumnLevelAndDept(level, deptid, showToUser);
	}

	public int getColumnLevelAndNoSameName(UlColumn column) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getColumnLevelAndNoSameName(column);
	}

	public List getListUsedForRole() throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getAllListJustUsedRight();
	}

	public List getListByDeptForColumn(String dept) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByDeptForColumn(dept);
	}

	public UlColumn getByIdForShow(int id) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getByIdForShow(id);
	}
	
	public int getColumnIdByEId(String oId, String eId) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getColumnIdByEId(oId, eId);
	}
	

	public int getColumnLevelMax3(int columnId) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getColumnLevelMax3(columnId);
	}

	public List getListByParentIdForShow(int id, String dept, int showToUser) throws Exception {
		// TODO Auto-generated method stub
		return columnDAO.getListByParentIdForShow(id, dept, showToUser);
	}

	public List getListByDeptForColumn( String dept, int isDelete, int showToUser, int includeContent, int openColumn) throws SQLException {
		return columnDAO.getListByDeptForColumn(dept, isDelete, showToUser, includeContent, openColumn);
	}
	
	public String getNavBarByLeafId(int columnId, String separator) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		List<UlColumn> l = getColumnLevelByLeafId(columnId);
		for (int i = l.size() - 1; i >= 0; i--) {
			sb.append(separator + l.get(i).getColumnName());
		}
		return sb.toString();
	}
	
	private List<UlColumn> getColumnLevelByLeafId(int columnId) throws Exception {
		List<UlColumn> l = new ArrayList<UlColumn>();
		UlColumn uc = null;
		do {
			uc = columnDAO.getById(columnId);
			l.add(uc);
			columnId = uc.getParentId();
		} while (uc.getParentId() != 0);
		
		return l;
	}
}
