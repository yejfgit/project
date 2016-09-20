package com.ulic.ulweb.ulweb2.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IContentTmplDao;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;

public class ContentTmplDao extends HibernateDaoSupport implements IContentTmplDao {

	public List findAll() {

		return this.getHibernateTemplate().find("from ContentTmplEntity order by tmplId");
	}

	public boolean save(ContentTmplEntity ct) {
		try {
			this.getHibernateTemplate().save(ct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public ContentTmplEntity getById(int id) {
		ContentTmplEntity ct = null;
		try {
			ct = (ContentTmplEntity) this.getHibernateTemplate().get(ContentTmplEntity.class, id);

		} catch (Exception e) {
			
		}
		return ct;
	}	
	
	public boolean update(ContentTmplEntity ct) {
		try {
			this.getHibernateTemplate().update(ct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delete(ContentTmplEntity ct) {
		try {
			this.getHibernateTemplate().delete(ct);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
