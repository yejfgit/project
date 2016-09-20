package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.ITestDao;
import com.survey.vo.Question;

public class TestDaoImpl extends HibernateDaoSupport implements ITestDao {

	public void test1() {
		
		final String sql = "select q.name as {qqq.name} " +
				" from t_sv_question q, t_sv_question_type_tbl qt " +
				" where q.type = qt.type_id ";
		
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				
				return session.createSQLQuery(sql).addEntity("qqq", Question.class).list();
			}
			
		});
		System.out.println(list.size());
	}

	public void test2() {
		
	}

	public void test3() {
		
	}

	public void test4() {
		
	}

}
