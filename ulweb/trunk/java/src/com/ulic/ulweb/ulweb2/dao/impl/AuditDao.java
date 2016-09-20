package com.ulic.ulweb.ulweb2.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IAuditDao;
import com.ulic.ulweb.ulweb2.entity.AuditEntity;

public class AuditDao extends HibernateDaoSupport implements IAuditDao {

	public boolean save(AuditEntity a) {
		try {
			this.getHibernateTemplate().save(a);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
