package com.survey.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IBaseDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.PageVO;


public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {

	public Object save(Object obj) {
		this.getHibernateTemplate().save(obj);
		return obj;
	}
	

	public void update(Object obj) {
		this.getHibernateTemplate().update(obj);
	}
	
	public void delete(Object obj) {
		this.getHibernateTemplate().delete(obj);
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
	
	
	public PageVO getListInPage(PageVO pvo, final String sql,
			final Class resultClazz) {

		Object count = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(
								"select count(*) from ( " + sql + " ) ")
								.uniqueResult();
					}
				});
		int totalNum = ((BigDecimal) count).intValue();
		pvo.setTotalNum(totalNum);
		
		if (totalNum == 0) {
			return null;
		}

		final int firstResult = pvo.getFirstResult();
		final int maxResults = pvo.getPageSize();

		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql).setFirstResult(
								firstResult).setMaxResults(maxResults)
								.setResultTransformer(
										new IgnoreCaseTransformer(resultClazz))
								.list();
					}
				});
		pvo.setObjectList(list);
		return pvo;

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

	
	public void batchSave(final List entityList) {
		this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Transaction tx = session.beginTransaction();
				for (int i = 0; i < entityList.size(); i++) {
					Object entity = entityList.get(i);
					session.save(entity);
					if (i % 1000 == 0) {
						session.flush();
						session.clear();
					}
					
				}
				tx.commit();
				return null;
			}
			
		});
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
}
