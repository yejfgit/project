package com.ulic.ulweb.dao.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.po.UlColumn;

/**
 * Data access object (DAO) for domain model class UlColumn.
 * 
 * @see entity.UlColumn
 * @author MyEclipse Persistence Tools
 */

public class UlColumnDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UlColumnDAO.class);

	public static UlColumnDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UlColumnDAO) ctx.getBean("UlColumnDAO");
	}
}