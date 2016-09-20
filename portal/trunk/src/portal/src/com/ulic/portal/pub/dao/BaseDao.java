package com.ulic.portal.pub.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.ulic.portal.pub.util.IgnoreCaseTransformer;
import com.ulic.portal.pub.vo.PageSupport;


@Repository
public class BaseDao extends HibernateDaoSupport {

	protected static Log log = LogFactory.getLog(BaseDao.class);
	

	@Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
    	super.setSessionFactory(sessionFactory);
    }

	
	public Object save(Object obj) {
		this.getHibernateTemplate().save(obj);
		return obj;
	}
	

	public void update(Object obj) {
		this.getHibernateTemplate().update(obj);
	}
	
	public void saveOrUpdate(Object obj)
	{
		this.getHibernateTemplate().saveOrUpdate(obj);
	}
	
	public List getListByProperty(String entity, String name, Object value) {

		return this.getHibernateTemplate().find(
				"from " + entity + " where " + name + " = ?", value);
	}
	
	public List getListByProperties(String entity, String[] names, Object[] values) {
		if (names == null || values == null || names.length == 0 || values.length == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < names.length; i++) {
			sb.append(" and " + names[i] + " = ?");
		}
		
		return this.getHibernateTemplate().find(
				"from " + entity + " where 1=1" + sb.toString(), values);
	}
	
	public List getList(String entity) {

		return this.getHibernateTemplate().find(
				"from " + entity);
	}

	public Object getById(Class c, int id) {
		
		return this.getHibernateTemplate().get(c, id);
	}

	public List getList(final String sql,
			final Class resultClazz) {

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(resultClazz))
								.list();
					}
				});

		return list;

	}
	

	public List getListInMap(final String sql) {
		
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {

				return session.createSQLQuery(sql)
				.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
				.list();
			}
			
		});
		return list;
	}
	
	
	public Object getRecord(final String sql,
			final Class resultClazz) {

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(resultClazz))
								.list();
					}
				});

		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	


	public void executeUpdate(final String sql) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.createSQLQuery(sql).executeUpdate();
				return null;
			}
			
		});
		
	}
	

	public void deleteById(String table, int id) {
		final String sql = "delete from " + table + " where id = " + id;
		this.executeUpdate(sql);
	}
	
	public void executeDelete(final String sql){
		this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.createSQLQuery(sql).executeUpdate();
				return null;
			}
			
		});
	}

	/**
	 * 分页查询
	 */
	public PageSupport findPageBySql(final String sqlQuery, final Class cls, final PageSupport ps, final List paramList)
	{
		PageSupport pageSupport = (PageSupport) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						
						
						Query countQuery = session.createSQLQuery("select count(*) from ( " + sqlQuery + " ) ");
						
						// 绑定变量
						for (int i = 0; i < paramList.size(); i++) {
							Object o = paramList.get(i);
							countQuery = countQuery.setParameter(i, o);
						}
						
						int totalCount = ((BigDecimal)countQuery.uniqueResult()).intValue();
						
						Query query = session.createSQLQuery(sqlQuery);
						
						// 绑定变量
						for (int i = 0; i < paramList.size(); i++) {
							Object o = paramList.get(i);
							query = query.setParameter(i, o);
						}
						
						query = query.setResultTransformer(new IgnoreCaseTransformer(cls));
						
						query.setFirstResult(ps.getStartRow(totalCount));
						query.setMaxResults(ps.getPageSize());
						List list = query.list();
						ps.fillPageList(list, totalCount, ps.getPageSize(), ps.getCurrentPage());
						return ps;
					}
				});
		return pageSupport;
	}


	
	public List getList(final String sql, final Class resultClazz, final List paramList) {
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query q = session.createSQLQuery(sql);
						
						// 绑定变量
						for (int i = 0; i < paramList.size(); i++) {
							Object o = paramList.get(i);
							q = q.setParameter(i, o);
						}
						
						return q.setResultTransformer(
								new IgnoreCaseTransformer(resultClazz))
								.list();
					}
				});

		return list;
	}
	
	
	public void executeUpdate(final String sql, final List paramList) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				
				Query q = session.createSQLQuery(sql);
				
				// 绑定变量
				for (int i = 0; i < paramList.size(); i++) {
					Object o = paramList.get(i);
					q = q.setParameter(i, o);
				}
				
				q.executeUpdate();
				return null;
			}
			
		});
		
	}


	public void deleteFileById(String table, int fileId){
		final String sql = "delete from " + table + " where file_id = " + fileId;
		this.executeUpdate(sql);
	}
	
	//强制保存某张表的信息
	public void saveTable(String entity) {
		 this.getHibernateTemplate().find("from " + entity + " where 1=0 " );
		 this.getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
	}
	
	public Object getById(Class c, String id){
		return this.getHibernateTemplate().get(c, id);
	}


	public List getListByPropertyInValues(Class clazz, String propertyName, Object[] valueList) {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.in(propertyName,valueList));
		return criteria.list();
	}


	public void flush() {
		this.getHibernateTemplate().getSessionFactory().getCurrentSession().flush();
		
	}
}
