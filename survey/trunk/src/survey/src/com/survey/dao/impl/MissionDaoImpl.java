package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IBaseDao;
import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.Mission;
import com.survey.vo.MissionVO;
import com.survey.vo.OptionAnswer;
import com.survey.vo.PageVO;
import com.survey.vo.ReportTimesVO;
import com.survey.vo.Survey;
import com.survey.vo.TextAnswer;
import com.survey.vo.User;

public class MissionDaoImpl extends HibernateDaoSupport implements IMissionDao {  
private IBaseDao baseDaoImpl;
	
	public IBaseDao getBaseDaoImpl() {
		return baseDaoImpl;
	}

	public void setBaseDaoImpl(IBaseDao baseDaoImpl) {
		this.baseDaoImpl = baseDaoImpl;
	}
	
	public List getUnFinished() { 
		StringBuffer sb = new StringBuffer(); 
		sb.append("select d.full_name deptFullName,u.real_name realName," +
				  "s.name surveyName," +
				  "to_timestamp(to_char(m.request_time, 'yyyy-mm-dd hh24:mi:ss'), " +
				" 'yyyy-mm-dd hh24:mi:ss') requestTime," +
				  "to_timestamp(to_char(m.begin_time, 'yyyy-mm-dd hh24:mi:ss'), " +
				" 'yyyy-mm-dd hh24:mi:ss') beginTime," +
				  "to_timestamp(to_char(m.finish_time, 'yyyy-mm-dd hh24:mi:ss'), " +
				" 'yyyy-mm-dd hh24:mi:ss') finishTime," +
				  "m.id missionId,m.isClosed isClosed " +
				  "from t_um_organ d,t_sv_mission m,t_um_user u,t_sv_survey s "+
                  "where d.um_organ_id = u.um_organ "+
                  "and m.user_id = u.um_user_id "+
                  "and s.id = m.survey_id "+
                  "and (m.isClosed = 0 or m.isclosed = 1)");
				
		final String sql = sb.toString();
		
		
		List ufList = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(MissionVO.class))
										.list();
					}
				}); 

		return ufList;
	}

	public Mission getByUserId(int userId,int surveyId) {
		List list = this.getHibernateTemplate().find(
		"from Mission m where m.isClosed in (0,1) and m.userId = '"+userId+"' and m.surveyId = '"+surveyId+"'" );
		if(list.size()==0){
			return null;
		}
		return (Mission) list.get(0);
	}

	public List getUnFinishedMission() {
		
		List ublist = this.getHibernateTemplate().find(
		"from Mission m where m.isClosed in (0, 1 , 5) ");
        return ublist;
	}

	public Mission getMissionById(int missionId) {
		
		List list = this.getHibernateTemplate().find(
				"from Mission m where m.id = '"+missionId+"'" );
				if(list.size()==0){
					return null;
				}
				return (Mission) list.get(0);
	}

	public List getUnFinishedMissionBySurveyId(int surveyId) {
		StringBuffer sb = new StringBuffer(); 
		sb.append("select t.id missionId,t.user_id userId,u.mail mail,s.name surveyName,t.isClosed isClosed " +
				"from t_sv_mission t,t_um_user u,t_sv_survey s "+ 
				"where t.user_id = u.um_user_id "+ 
				"and t.survey_id = s.id "+
				"and t.isclosed in (0,1) "+
				"and t.survey_id = "+surveyId+" ");
				
		final String sql = sb.toString();
		
		
		List ufList = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(MissionVO.class))
										.list();
					}
				}); 

		return ufList;
	}

	public List getFinishedMission(int surveyId) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find(
		"from Mission m where m.isClosed = 2 and m.surveyId = " + surveyId);
        return list;
	}

	public List getUnBeginMission(int surveyId) {
		List list = this.getHibernateTemplate().find(
				"from Mission m where m.isClosed = 0 and m.surveyId = " + surveyId);
	    return list;
	}
	
	public List getBUnFinishMission(int surveyId) {
		List list = this.getHibernateTemplate().find(
				"from Mission m where m.isClosed in (1,5) and m.surveyId = " + surveyId);
	    return list;
	}

	public List getMissionBySurveyId(int surveyId) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find(
				"from Mission m where m.surveyId = " + surveyId);
	    return list;
	}

	public List getUnFinished(String startDate, String endDate, int surveyId, int deptId) {

			StringBuffer sb = new StringBuffer();
			sb
					.append("select d.full_name deptFullName,u.real_name realName,"
							+ "to_timestamp(to_char(m.request_time, 'yyyy-mm-dd hh24:mi:ss'), " +
							" 'yyyy-mm-dd hh24:mi:ss') requestTime," +
							  "to_timestamp(to_char(m.begin_time, 'yyyy-mm-dd hh24:mi:ss'), " +
							" 'yyyy-mm-dd hh24:mi:ss') beginTime," +
							  "to_timestamp(to_char(m.finish_time, 'yyyy-mm-dd hh24:mi:ss'), " +
							" 'yyyy-mm-dd hh24:mi:ss') finishTime," +
							  "m.id missionId,m.isClosed isClosed, " 
							+ "s.name surveyName "
							+ "from t_sv_survey s,t_um_user u,t_sv_mission m,t_um_organ d "
							+ "where u.um_user_id = m.user_id "
							+ "and u.um_organ = d.um_organ_id "
							+ "and s.id = m.survey_id "
							+ "and d.um_organ_id in (select a.um_organ_id from ( "
							+ "select d.um_organ_id , d.full_name , "
							+ "parent_id  "
							+ "from t_um_organ d "
							+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
							+ deptId
							+ "')) a ) "
							+ "and m.survey_Id = '"
							+ surveyId
							+ "' "
							+ "and m.request_time > to_date('"
							+ startDate
							+ "', 'YYYY-MM-DD') "
							+ "and m.request_time < to_date('"
							+ endDate
							+ "','YYYY-MM-DD') + 1 " +
									"order by case when m.isClosed = 5 then 1 end asc, m.isclosed asc, m.id desc");
			;

			final String sql = sb.toString();
		
			List list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							return session.createSQLQuery(sql)
									.setResultTransformer(
											new IgnoreCaseTransformer(
													MissionVO.class)).list();
						}
					});
			return list;

	}
	
	public List getUnFinished(String startDate, String endDate, int deptId) {
		StringBuffer sb = new StringBuffer();
		sb
				.append("select d.full_name deptFullName,u.real_name realName,"
						+ "to_timestamp(to_char(m.request_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') requestTime," +
						  "to_timestamp(to_char(m.begin_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') beginTime," +
						  "to_timestamp(to_char(m.finish_time, 'yyyy-mm-dd hh24:mi:ss'), " +
						" 'yyyy-mm-dd hh24:mi:ss') finishTime," +
						  "m.id missionId,m.isClosed isClosed, " 
						+ "s.name surveyName "
						+ "from t_sv_survey s,t_um_user u,t_sv_mission m,t_um_organ d "
						+ "where u.um_user_id = m.user_id "
						+ "and u.um_organ = d.um_organ_id "
						+ "and s.id = m.survey_id "
						+ "and d.um_organ_id in (select a.um_organ_id from ( "
						+ "select d.um_organ_id , d.full_name , "
						+ "parent_id  "
						+ "from t_um_organ d "
						+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
						+ deptId
						+ "')) a ) "
						+ "and m.request_time > to_date('"
						+ startDate
						+ "', 'YYYY-MM-DD') "
						+ "and m.request_time < to_date('"
						+ endDate
						+ "','YYYY-MM-DD') + 1 " +
						"order by case when m.isClosed = 5 then 1 end asc, m.isclosed asc, m.id desc");
		;

		final String sql = sb.toString();

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												MissionVO.class)).list();
					}
				});

		return list;

	}


	public List getAnswersByMissionId(int id) {
		List list = this.getHibernateTemplate().find(
				"from Answer a where a.missionId = " + id);
	    return list;
	}

	public OptionAnswer getOaByAnswerId(int id) {
		List list = this.getHibernateTemplate().find(
				"from OptionAnswer a where a.answerId = " + id);
	    if(list.size()>0){
	    	return (OptionAnswer) list.get(0);
	    }else{
			return null;
	    }

	}

	public void deleteEntity(Object obj) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(obj);
	}

	public TextAnswer getTaByAnswerId(int id) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find(
				"from TextAnswer a where a.answerId = " + id);
	    if(list.size()>0){
	    	return (TextAnswer) list.get(0);
	    }else{
			return null;
	    }
	}


}
