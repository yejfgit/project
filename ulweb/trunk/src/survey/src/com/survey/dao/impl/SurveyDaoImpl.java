package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.ISurveyDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.MissionVO;
import com.survey.vo.Survey;
import com.survey.vo.SurveyVO;

public class SurveyDaoImpl extends HibernateDaoSupport implements ISurveyDao {

	public List getSurveyList() {

		List list = this.getHibernateTemplate().find("from Survey s ");
		return list;
	}

	public Object saveEntity(Object entity) {
		this.getHibernateTemplate().save(entity);
		return entity;
	}

	public List getListByProperty(String entity, String name, Object value) {

		return getListByProperty(entity, name, value, null);
	}

	public List getListByProperty(String entity, String name, Object value, String orderBy) {

		orderBy = (orderBy == null ? "" : " order by " + orderBy);
		return this.getHibernateTemplate().find(
				"from " + entity + " where " + name + " = ?" + orderBy, value);
	}

	public Object getEntityById(Class c, int id) {

		return this.getHibernateTemplate().get(c, id);
	}

	public void updateEntity(Object entity) {

		this.getHibernateTemplate().update(entity);
	}

	public List getSurveyListByAdminUserId(int userId) {

		List list = this.getHibernateTemplate().find(
				"from Survey s  order by s.id desc ");
		return list;
	}

	public List getSurveyListByUserId(int userId) {
		final String sql = "select s.id id,s.name name,m.request_time requestTime "
				+ "from t_sv_survey s,t_sv_mission m "
				+ "where s.id = m.survey_id "
				+ "and (m.isClosed = 0 or m.IsClosed =1) "
				+ "and m.user_Id = '"
				+ userId
				+ "' "
				+ "order by m.request_time ";

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

	public Survey getById(int surveyId) {
		final String sql = "select s.id id,s.name name,s.tips tips "
				+ "from t_sv_survey s,t_sv_mission m "
				+ "where s.id = m.survey_id " + "and m.isClosed = 0 "
				+ "and m.survey_Id = " + surveyId;

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												Survey.class)).list();
					}
				});
		return (Survey) list.get(0);
	}

	public List getQuestionsBySurveyId(int surveyId) {
		final String sql = "select s.id surveyId,s.name surveyName,q.name questionName,q.seq questionSeq "
				+ "from t_sv_survey s,t_sv_question q "
				+ "where s.id = q.survey_id " + "and s.id = " + surveyId;

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(SurveyVO.class)).list();
					}
				});
		return list;
	}

	public List getAnswersById(int surveyId, int seq, String optionName,
			String startDate, String endDate, int deptId) {
		final String sql = "select o.name "
				+ "from t_sv_mission m,t_sv_survey s,t_sv_answer a,t_sv_question q,t_sv_option_answer oa,t_sv_option o "
				+ "where m.survey_id = q.survey_id "
				+ "and s.id = m.survey_id " + "and q.id = a.question_id "
				+ "and a.id = oa.answer_id " + "and oa.option_id = o.id "
				+ "and m.id = a.mission_id " + "and m.dept_id in (select a.um_organ_id from ( " +
				"select d.um_organ_id , d.full_name , " +
				"parent_id  "+
				"from t_um_organ d " +
				"connect by prior um_organ_id = parent_id start with um_organ_id in ('"+deptId+"')) a ) " + 
				"and m.survey_id = " + surveyId + "and o.name='"
				+ optionName + "' " + "and q.seq=  '" + seq + "' "
				+ "and m.finish_time > to_date('" + startDate
				+ "', 'YYYY-MM-DD') " + "and m.finish_time < to_date('"
				+ endDate + "','YYYY-MM-DD') + 1";

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												SurveyVO.class)).list();
					}
				});
		return list;
	}

	public List getTotalAnswerById(int surveyId, String optionName,
			String startDate, String endDate, int deptId) {
		final String sql = "select o.name "
				+ "from t_sv_mission m,t_sv_survey s,t_sv_answer a,t_sv_question q,t_sv_option_answer oa,t_sv_option o "
				+ "where m.survey_id = q.survey_id "
				+ "and s.id = m.survey_id "
				+ "and q.id = a.question_id "
				+ "and a.id = oa.answer_id "
				+ "and oa.option_id = o.id "
				+ "and m.id = a.mission_id "
				+ "and m.dept_id in (select a.um_organ_id from ( "
				+ "select d.um_organ_id , d.full_name , "
				+ "parent_id  "
				+ "from t_um_organ d "
				+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
				+ deptId + "')) a ) " + "and m.survey_id = " + surveyId
				+ "and o.name='" + optionName + "' "
				+ "and m.finish_time > to_date('" + startDate
				+ "', 'YYYY-MM-DD') " + "and m.finish_time < to_date('"
				+ endDate + "','YYYY-MM-DD') + 1";

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												SurveyVO.class)).list();
					}
				});
		return list;
	}

	public List getOptionScoreById(int surveyId) {
		final String sql = "select o.score "
				+ "from t_sv_survey s,t_sv_question q,t_sv_option o "
				+ "where s.id = q.survey_id " + "and q.id = o.question_id "
				+ "and s.id = " + surveyId;

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												SurveyVO.class)).list();
					}
				});
		return list;
	}

	public Survey getSurveyById(int surveyId) {
	    
		return (Survey) this.getHibernateTemplate().get(Survey.class,surveyId);
	}

}
