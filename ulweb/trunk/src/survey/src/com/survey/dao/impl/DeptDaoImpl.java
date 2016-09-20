package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IDeptDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.Dept;
import com.survey.vo.MissionVO;
import com.survey.vo.ReportTimesVO;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmOrganVO;
import com.survey.vo.User;



public class DeptDaoImpl extends HibernateDaoSupport implements IDeptDao {


	public List getDept(){
		StringBuffer sb = new StringBuffer(); 
		sb.append("select to_number(t.um_organ_id) id," +
			"t.abbr_name deptName," +
			"to_number(t.parent_id) parentId," +
			"t.org_level  deptLevel " +
			"from t_um_organ t "+
            //"where t.full_name not like '%室%' "+
            "order by to_number(t.um_organ_id) ");
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(Dept.class))
										.list();
					}
				});

		return list;
	}


	public List<Dept> findBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> findDeptByParentId(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> findTree() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Dept> findTreeByParentId(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Dept getDeptById(int id) {
		StringBuffer sb = new StringBuffer(); 
		sb.append("select t.abbr_name deptFullName,t.um_organ_id id " +
				"from t_um_organ t " +
				"where to_number(t.um_organ_id) = " + id);
			
				
		final String sql = sb.toString();
		
		
		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(Dept.class))
										.list();
					}
				});

		if (list.size() == 0) {
			return null;
		} else {
			return (Dept) list.get(0);
		}
	}

	public List getUsersByDeptId(int deptId) {
		StringBuffer sb = new StringBuffer(); 
//		sb.append("select to_number(t.um_user_id) id,t.real_name realName "+ 
//				"from t_um_user t " +
//				"where t.um_organ in " +
//				"(select o.um_organ_id " +
//				"from t_um_organ o " +
//				"connect by prior o.parent_id = o.um_organ_id "+
//				"start with o.parent_id = '"+ deptId +"' )");
		sb.append("select t.real_name realName,t.um_user_id id " +
				"from t_um_user t " +
				"where t.is_activie = 'Y'  " +
				"and t.um_organ in " +
				"(select a.um_organ_id from ( " +
				"select d.um_organ_id , d.full_name , " +
				"parent_id  "+
				"from t_um_organ d " +
				"connect by prior um_organ_id = parent_id start with um_organ_id in ('"+deptId+"')) a ) order by nlssort (t.real_name,'NLS_SORT=SCHINESE_PINYIN_M') asc");
				
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

		return list;
	}
	

	
}
