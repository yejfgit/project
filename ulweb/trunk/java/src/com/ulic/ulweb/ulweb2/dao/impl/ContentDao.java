package com.ulic.ulweb.ulweb2.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.jdom.Parent;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ulic.ulweb.ulweb2.dao.IContentDao;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;
import com.ulic.ulweb.ulweb2.entity.ContentClicksGoodEntity;
import com.ulic.ulweb.ulweb2.entity.ContentEntity;
import com.ulic.ulweb.ulweb2.entity.MonitorClicksEntity;
import com.ulic.ulweb.ulweb2.entity.PageEntity;

public class ContentDao extends HibernateDaoSupport implements IContentDao {  

	public List findAll() {

		return this.getHibernateTemplate().find("from ContentEntity");
	}

	public ContentEntity getById(int id) {
		ContentEntity c = null;
		try {
			List l = this.getHibernateTemplate().find("from ContentEntity where contentId = ?", id);
			if (l != null && l.size() > 0) {
				c = (ContentEntity) l.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public boolean delete(ContentEntity c) {
		try {
			this.getHibernateTemplate().delete(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public ContentEntity save(ContentEntity c) {
		try {
			this.getHibernateTemplate().save(c);
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(ContentEntity c) {
		try {
			this.getHibernateTemplate().update(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public PageEntity findByProperties(PageEntity pe) {

		final int pageSize = pe.getPageSize();
		final int firstResult = pe.getFirstResult();
		final DetachedCriteria dc = pe.getCondition();

		List cl = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria c = dc.getExecutableCriteria(session).setProjection(Projections.rowCount());
				return c.list();
			}
			
		});
		int max = ((Integer)cl.get(0)).intValue();
		pe.setTotalNum(max);
		dc.setProjection(null);
				
		List l = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria c = dc.getExecutableCriteria(session)
				.setMaxResults(pageSize).setFirstResult(firstResult);
				return c.list();
			}
			
		});
		pe.setObjectList(l);
		
		return pe;
	}

	public PageEntity findByParentId(PageEntity pe, int parentId) {
		final int pageSize = pe.getPageSize();
		final int firstResult = pe.getFirstResult();

		List cl = this.getHibernateTemplate().find("from ColumnEntity where parentId = ? ", parentId);
		StringBuffer sb = new StringBuffer();
		Iterator iter = cl.iterator();
		while (iter.hasNext()) {
			ColumnEntity c = (ColumnEntity) iter.next();
			if (c.getIncludeContent() == 1) {
				sb.append(c.getColumnId() + ",");
			}
		}
		if(sb.indexOf(",") != -1) {
			sb.delete(sb.length() - 1, sb.length());
		}
		//System.out.println(sb.toString());
		
		if ("".equals(sb.toString())) {
			pe.setObjectList(new ArrayList());
			return pe;
		}
		
		final String sql = "from ContentEntity " +
				" where columnId in (" + sb.toString() + ") " +
				" and isDelete = 0 and isProcessing = 0 " +
				" order by orderNum desc, contentId desc ";
		
		Object m = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = (Query) session.createQuery("select count(*) " + sql);
				return q.uniqueResult();
			}
		});
		int max = ((Long)m).intValue();

		pe.setTotalNum(max);
		
		List l = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = (Query) session.createQuery(sql)
				.setMaxResults(pageSize).setFirstResult(firstResult);
				return q.list();
			}
			
		});
		pe.setObjectList(l);
		
		return pe;
	}
	
	public PageEntity findByPropertyMap(PageEntity pe) {
		final int pageSize = pe.getPageSize();
		final int firstResult = pe.getFirstResult();
		
		final Map qM = pe.getQueryCondition();
		
		final String sql = "from ContentEntity "
			+ pe.getQueryConditionString()
			+ pe.getQueryOrderString();
		//System.out.println(sql);
		
		Object m = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = (Query) session.createQuery("select count(*) " + sql)
				.setProperties(qM);
				return q.uniqueResult();
			}
		});
		int max = ((Long)m).intValue();

		pe.setTotalNum(max);
		
		List l = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query q = (Query) session.createQuery(sql).setProperties(qM)
				.setMaxResults(pageSize).setFirstResult(firstResult);
				return q.list();
			}
			
		});
		pe.setObjectList(l);
		
		return pe;
	}

	public List getListById(int oldId) {
		// TODO Auto-generated method stub
		 List list = this.getHibernateTemplate().find("from ContentEntity t " +
				" where t.columnId = '" + oldId +"' order by t.orderNum "
				);
	
		return list;
	}
	
	public List getTopClickNumListById(int oldId) {
		// TODO Auto-generated method stub
		
		/*String sql =  " select t.content_id contentId,t1.clicks_nums num " +
				  	  " from UL_CONTENT t, ul_monitor_clicks t1 " +
					  " where t.column_id = " +oldId+
					  " and t.content_id = t1.content_id " +
					  " order by num desc ";
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createSQLQuery(sql);
		//query.setInteger("columnId", oldId);
		List list = query.list();
		session.close();
		//this.getSession().close();
		return list;*/
		
		List list = this.getHibernateTemplate().find("from MonitorClicksEntity t " +
				" where t.contentId in (select k.contentId from ContentEntity k where k.columnId = "+oldId+") order by t.clicksNums desc "
		);
		return list;
	}
	
	
	public List getClicksGoodListByContentid(int contentId) {

		
		List list = this.getHibernateTemplate().find("from ContentClicksGoodEntity t " +
				" where t.contentId = "+contentId+" order by t.type "
		);
		return list;
	}
	
	public ContentClicksGoodEntity getClicksGood(int contentId,int type) {

		
		List list = this.getHibernateTemplate().find("from ContentClicksGoodEntity t " +
				" where t.contentId = "+contentId+" and t.type="+type+" order by t.type "
		);
		if(list.size()!=0){
			return (ContentClicksGoodEntity) list.get(0);
		}else{
			return null;	
		}
	}
	public void addClicksGood(int contentId,int type,long clicks) {
		// TODO Auto-generated method stub
		ContentClicksGoodEntity m = new ContentClicksGoodEntity();
		m.setContentId(contentId);
		m.setClicksNums(clicks);
		m.setType(type);

		try {
			this.getHibernateTemplate().save(m);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void updateClicksGood(ContentClicksGoodEntity m) {

		try {
			this.getHibernateTemplate().update(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List getLastContentByContentIds(String ContentIds) {
		List list = this.getHibernateTemplate().find("from ContentEntity t " +
				" where t.contentId in (" + ContentIds +") order by t.orderNum desc "
		);
		return list;
	
	}

	public ContentEntity getLastContentByColumnId(int columnId) {
		List list = this.getHibernateTemplate().find("from ContentEntity t " +
				" where t.columnId = '" + columnId +"' order by t.orderNum desc "
		);
		if(list.size()!=0){
			return (ContentEntity) list.get(0);
		}else{
			return null;	
		}
	
	}

	
}
