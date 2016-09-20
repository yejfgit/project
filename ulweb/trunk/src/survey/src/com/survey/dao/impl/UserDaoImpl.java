package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IUserDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.MissionVO;
import com.survey.vo.TUmUser;
import com.survey.vo.User;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	public TUmUser getUmUserByUserId(int userId) {
//		List list = this.getHibernateTemplate().find(
//				"from TUmUser t where t.userName = ? ",
//				userName);
//		return (TUmUser) list;
//	}       
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
		List list = this.getHibernateTemplate().find(
		"from User t where t.userName = ? ", name);
		if (list.size() == 0) {
			return null;
		} else {
			return (User) list.get(0);
		}
		
        
	}

}