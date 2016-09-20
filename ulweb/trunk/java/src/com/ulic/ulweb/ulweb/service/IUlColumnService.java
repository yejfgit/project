package com.ulic.ulweb.ulweb.service;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlColumn;

public interface IUlColumnService extends IService {
	public void addColumn(UlColumn UlColumn) throws Exception;
	public String deleteColumn(int id) throws Exception;
	public void updateColumn(UlColumn uc) throws Exception;
	public UlColumn getColumnById(int id) throws Exception;
	public List getColumnsByParentId(int id, String dept) throws Exception;
	public List getListWOrganClassByParentId(int oClass, int id) throws Exception;
	public List getListWOtherClassByParentId(int oClass, int id) throws Exception;
	public List getListByChackKeyword(String ids, String keyword) throws Exception;
	public List getListByColumnIds(String ids) throws Exception;
	public List getListByColumnLevelAndDept(int level, String deptid, int showToUser) throws Exception;
	public int getColumnLevelAndNoSameName(UlColumn column) throws Exception;
	public List getListUsedForRole() throws Exception;
	public List getListByDeptForColumn( String dept) throws Exception;
	public UlColumn getByIdForShow(int id) throws Exception;
	public int getColumnIdByEId(String oId, String eId) throws Exception;
	public int getColumnLevelMax3(int columnId) throws Exception;
	public List getListByParentIdForShow(int id, String dept, int showToUser) throws Exception;
	public List getListByDeptForColumn( String dept, int isDelete, int showToUser, int includeContent, int openColumn) throws SQLException ;
	public String getNavBarByLeafId(int columnId, String separator) throws Exception;
}
