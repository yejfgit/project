package com.ulic.ulweb.ulweb2.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;

public interface IColumnService extends IService {

	List findColumnsByDeptId(String deptId);
	
	List findColumnsByColumnIds(int[] columnIds);

	ColumnEntity getColumnById(int id);

	boolean saveColumn(ColumnEntity c);

	boolean updateColumn(ColumnEntity c);

	boolean delColumnById(int id);

	/**
	 * 得到某栏目对应的内容模板，如果当前栏目没有，继续查找父级栏目或所属部门
	 * @param columnId
	 * @return
	 */
	ContentTmplEntity getContentTmplByColumnId(int columnId) throws Exception;

	ColumnEntity getColumnByEnname(String deptId, String enName);
	
	List findColumnsByParentId(int parentId);

}
