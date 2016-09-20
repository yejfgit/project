package com.ulic.ulweb.dao.hibernate;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.po.UlAttachment;

/**
 * Data access object (DAO) for domain model class UlAttachment.
 * 
 * @see entity.UlAttachment
 * @author MyEclipse Persistence Tools
 */

public class UlAttachmentDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UlAttachmentDAO.class);

	public static UlAttachmentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UlAttachmentDAO) ctx.getBean("UlAttachmentDAO");
	}
}