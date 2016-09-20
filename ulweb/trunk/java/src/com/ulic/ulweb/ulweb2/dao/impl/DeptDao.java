package com.ulic.ulweb.ulweb2.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IDeptDao;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;

public class DeptDao extends HibernateDaoSupport implements IDeptDao {

	public List findAll() {

		return this.getHibernateTemplate().find("from DeptEntity order by deptId");
	}

	public DeptEntity getById(String id) {
		DeptEntity d = null;
		try {
			List l = this.getHibernateTemplate().find("from DeptEntity where deptId = ?", id);
			if (l != null && l.size() > 0) {
				d = (DeptEntity) l.get(0);
			}
		} catch (Exception e) {
			
		}
		return d;
	}

	public boolean delete(DeptEntity d) {
		try {
			this.getHibernateTemplate().delete(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean save(DeptEntity d) {
		try {
			this.getHibernateTemplate().save(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(DeptEntity d) {
		try {
			this.getHibernateTemplate().update(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
