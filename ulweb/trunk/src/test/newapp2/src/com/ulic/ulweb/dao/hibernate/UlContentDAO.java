package com.ulic.ulweb.dao.hibernate; 

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.po.UlContent;

/**
 * Data access object (DAO) for domain model class UlContent.
 * 
 * @see entity.UlContent
 * @author MyEclipse Persistence Tools
 */

public class UlContentDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UlContentDAO.class);

	public static UlContentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UlContentDAO) ctx.getBean("UlContentDAO");
	}
}