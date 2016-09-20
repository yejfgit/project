package com.ulic.ulweb.ulweb2.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IColumnDao;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;

public class ColumnDao extends HibernateDaoSupport implements IColumnDao {

	public List findAll() {

		return this.getHibernateTemplate().find("from DeptEntity");
	}

	public ColumnEntity getById(int id) {
		ColumnEntity c = null;
		try {
			List l = this.getHibernateTemplate().find("from ColumnEntity where columnId = ?", id);
			if (l != null && l.size() > 0) {
				c = (ColumnEntity) l.get(0);
			}
		} catch (Exception e) {
			
		}
		return c;
	}

	public boolean delete(ColumnEntity c) {
		try {
			this.getHibernateTemplate().delete(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean save(ColumnEntity c) {
		try {
			this.getHibernateTemplate().save(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(ColumnEntity c) {
		try {
			this.getHibernateTemplate().update(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List findByProperties(String[] paramNames, Object[] values) {

		StringBuffer sb = new StringBuffer();
		sb.append("from ColumnEntity where 1=1");
		for (int i = 0; i < paramNames.length; i++) {
			sb.append(" and " + paramNames[i] + "=?");
		}
		sb.append(" order by includeContent, columnOrder, columnId ");
		String hql = sb.toString();
		//System.out.println("columnDao.findByProperties:" + hql);
		List l = null;
		try {
			l = this.getHibernateTemplate().find(hql, values);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}

	
}
