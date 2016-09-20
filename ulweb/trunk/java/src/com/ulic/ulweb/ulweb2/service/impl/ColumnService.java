package com.ulic.ulweb.ulweb2.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ulic.ulweb.ulweb2.dao.IColumnDao;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;
import com.ulic.ulweb.ulweb2.service.IColumnService;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;
import com.ulic.ulweb.ulweb2.service.IDeptService;

public class ColumnService implements IColumnService {
	private IColumnDao columnDao;
	
	private IContentTmplService contentTmplService;
	
	private IDeptService deptService;

	public void setColumnDao(IColumnDao columnDao) {
		this.columnDao = columnDao;
	}
	
	public void setContentTmplService(IContentTmplService contentTmplService) {
		this.contentTmplService = contentTmplService;
	}	

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}


	public List findColumnsByDeptId(String deptId) {
		//System.out.println("deptId:" + deptId);
		return columnDao.findByProperties(
				new String[]{"organId", "isDelete"}, new Object[]{deptId, 0});
	}

	public ColumnEntity getColumnById(int id) {
		
		return columnDao.getById(id);
	}

	public List findColumnsByColumnIds(int[] columnIds) {
		List l = new ArrayList();
		int pId;
		for (int i = 0; i < columnIds.length; i++) {
			ColumnEntity c = this.getColumnById(columnIds[i]);
			if (c != null) {
				c.setParentId(0);
				l.add(c);
			}
		}
		return l;
	}

	public boolean saveColumn(ColumnEntity c) {

		return columnDao.save(c);
	}

	public boolean updateColumn(ColumnEntity c) {

		return columnDao.update(c);
	}

	public boolean delColumnById(int id) {
		
		ColumnEntity c = this.getColumnById(id);
		if (c == null) {
			return false;
		} else {
			c.setColumnName(c.getColumnName() + "-" + new Date());
			c.setIsDelete(1);
			return columnDao.update(c);
		}
	}

	public ContentTmplEntity getContentTmplByColumnId(int columnId) throws Exception {
		int tmplId = 0;
		ColumnEntity col = this.getColumnById(columnId);
		int pId;
		while (true) {
			tmplId = col.getContentTmplId();
			if (tmplId == 0 || tmplId == -1) {
				if ((pId = col.getParentId()) == 0) {
					DeptEntity d = deptService.getDeptById(col.getOrganId());
					tmplId = d.getContentTmplId();
					break;
				} else {
					col = this.getColumnById(pId);
				}
			} else {
				tmplId = col.getContentTmplId();
				break;
			}
		}
		
		return contentTmplService.getTmplById(tmplId);
	}

	public List findColumnsByParentId(int parentId) {
		
		return columnDao.findByProperties(new String[] {"parentId", "showToUser", "isDelete"}, new Object[] {parentId, 1, 0});
	}

	public ColumnEntity getColumnByEnname(String deptId, String enName) {
		List l = columnDao.findByProperties(new String[] {"organId", "columnEid"}, 
				new Object[] {deptId, enName});
		if (l == null || l.isEmpty()) {
			return null;
		}
		return (ColumnEntity) l.get(0);
	}





}
