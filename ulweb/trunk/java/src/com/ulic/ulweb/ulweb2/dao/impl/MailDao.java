package com.ulic.ulweb.ulweb2.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IMailDao;
import com.ulic.ulweb.ulweb2.entity.MailEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public class MailDao extends HibernateDaoSupport implements IMailDao{

	Log log = LogFactory.getLog(getClass());
	
	public PageEntity listMail(PageEntity pe) {
		final int pageSize = pe.getPageSize();
		final int firstResult = pe.getFirstResult();
		final Map qc = pe.getQueryCondition();
		
		StringBuffer sb = new StringBuffer();
		sb.append("from MailEntity");
		sb.append(pe.getQueryConditionString());
		sb.append(pe.getQueryOrderString());
		final String hql = sb.toString();
		
		List cl = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = session.createQuery("select count(*) " + hql).setProperties(qc);
				return q.list();
			}
			
		});
		int max = ((Long)cl.get(0)).intValue();
		pe.setPageTotalNum(max / pageSize + 1);
		
		if(max != 0){
	
			List l = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query q = session.createQuery(hql).setProperties(qc)
					.setMaxResults(pageSize).setFirstResult(firstResult);
					return q.list();
				}
				
			});
			pe.setObjectList(l);
		
		}else{
			pe.setObjectList(new ArrayList());
		}
		
		return null;
	}

	public void save(MailEntity mail) {
		try {
			this.getHibernateTemplate().save(mail);			
		} catch (Exception e) {
			//e.printStackTrace();
			log.info("-------MailDao:save  mail cant save");
		}
	}
	

}
