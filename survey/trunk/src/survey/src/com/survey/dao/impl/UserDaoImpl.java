package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IUserDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.DispatchUser;
import com.survey.vo.MissionVO;
import com.survey.vo.TUmUser;
import com.survey.vo.User;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	public TUmUser getUmUserByUserId(int userId) {

		    String d = String.valueOf(userId);
	
			return (TUmUser) this.getHibernateTemplate().get(TUmUser.class,d);
		}
	
	public TUmUser getUmUserByUserName(String userName){
		
		return(TUmUser)this.getHibernateTemplate().get(User.class,userName);
//		List list = this.getHibernateTemplate().find(
//		"from TUmUser t where t.userName = ? ",
//		userName);
//		
//		TUmUser tum = (TUmUser)list[0];
//        return (TUmUser) tum;
	}
	public User getUserById(int id) {
		return (User) this.getHibernateTemplate().get(User.class,id);
	}
	public User getUserByUserName(String name) {
		System.out.println(name);
		StringBuffer sb = new StringBuffer(); 
		sb.append("select to_number(t.um_user_id) id " +
				"from t_um_user t where t.user_name ='" +name+"'");
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(User.class))
										.list();
					}
				}); 

		return (User) list.get(0);
   }
	
	public User getByUserName(String name){
		StringBuffer sb = new StringBuffer(); 
		sb.append("select t.real_name realName,t.um_user_id id,t.um_organ deptId,t.user_name userName "+ 
				"from t_um_user t where t.user_name = '"+name+"' "+
				" and t.user_type = 1");
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(User.class))
										.list();
					}
				}); 

		if (list.size() == 0) {
			return null;
		} else {
			return (User) list.get(0);
		}
		
        
	}

	public DispatchUser getDispatchUserByEmpId(String string) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(); 
		sb.append("select t.emp_name empName,u.real_name realName,t.work_email workEmail,t.empid empId, "+
				"u.um_user_id umUserId,u.um_organ umOrgan,u.user_name userName  "+
				"from t_sv_users t,t_um_user u where t.empid = u.employee_number "+
				"and t.empid = '"+ string +"'");
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(DispatchUser.class))
										.list();
					}
				}); 

		if (list.size() == 0) {
			return null;
		} else {
			return (DispatchUser) list.get(0);
		}
	}

	public DispatchUser getDispatchUserByUmUserId(int userId) {
		// TODO Auto-generated method stub
//		 TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer(); 
		sb.append("select t.emp_name empName,u.real_name realName,t.work_email workEmail,t.empid empId, "+
				"u.um_user_id umUserId,u.um_organ umOrgan "+
				"from t_sv_users t,t_um_user u where t.empid = u.employee_number "+
				"and u.um_user_id = '"+ userId +"'");
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(DispatchUser.class))
										.list();
					}
				}); 

		if (list.size() == 0) {
			return null;
		} else {
			return (DispatchUser) list.get(0);
		}
	}

}