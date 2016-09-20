package com.ulic.ulweb.dao.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.po.UlRoleClass;

/**
 * Data access object (DAO) for domain model class UlRoleClass.
 * 
 * @see entity.UlRoleClass
 * @author MyEclipse Persistence Tools
 */

public class UlRoleClassDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UlRoleClassDAO.class);

	protected void initDao() {
		// do nothing
	}

	public static UlRoleClassDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UlRoleClassDAO) ctx.getBean("UlRoleClassDAO");
	}
}