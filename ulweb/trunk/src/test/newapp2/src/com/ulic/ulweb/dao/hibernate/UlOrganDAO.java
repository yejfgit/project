package com.ulic.ulweb.dao.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.po.UlOrgan;

/**
 * Data access object (DAO) for domain model class UlOrgan.
 * 
 * @see entity.UlOrgan
 * @author MyEclipse Persistence Tools
 */

public class UlOrganDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UlOrganDAO.class);

	public static UlOrganDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UlOrganDAO) ctx.getBean("UlOrganDAO");
	}
}