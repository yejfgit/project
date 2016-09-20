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
import com.survey.vo.Option;
import com.survey.vo.Survey;
import com.survey.vo.SurveyVO;
import com.survey.vo.TSendEmail;
import com.survey.vo.TextAnswer;

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

//		List list = this.getHibernateTemplate().find(
//				"from Survey s where s.ownerId = " + userId + 
//						" and s.isDelete = 0 order by s.id desc ");
//		return list;
		
		final String sql = "select s.id id,s.name name,s.owner_id ownerId,s.type type,s.is_delete isDelete,nvl(a.num, 0) num,s.create_time createTime " +
				"from t_sv_survey s,"+
				"(select s.id id,count(1) num from t_sv_mission t,t_sv_survey s "+
			"where  s.id = t.survey_id " +
			"and t.isclosed in (0,1) "+
			"group  by s.id) a "+
			"where s.id=a.id(+) "+
			"and s.is_delete = 0 " +
			"and s.owner_id = '" + userId+"'" +
			"order by s.id desc";

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
	
public List getSurveyListByUserIdAndType(int userId,int type) {
		
		final String sql = "select s.id id,s.name name,m.request_time requestTime "
				+ "from t_sv_survey s,t_sv_mission m "
				+ "where s.id = m.survey_id "
				+ "and (m.isClosed = 0 or m.IsClosed =1) "
				+ "and m.user_Id = '" + userId + "' "
				+ " and m.type = '"+ type+ "' "
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
		final String sql = "select s.owner_id ownerId,s.time_limit timeLimit, s.id id,s.name name,s.tips tips,s.type type,s.is_open isOpen "
				+ "from t_sv_survey s,t_sv_mission m "
				+ "where s.id = m.survey_id " + "and m.isClosed in (0,1,5) "
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
		if(list.size()==0){
			return null;
		}else{
			return (Survey) list.get(0); 
		}
	}

	public List getQuestionsBySurveyId(int surveyId) {
		final String sql = "select s.id surveyId ,s.name surveyName,q.name questionName,q.seq questionSeq,q.id questionId "
				+ "from t_sv_survey s,t_sv_question q "
				+ "where s.id = q.survey_id " 
				+ "and s.id = " + surveyId
				+ "and q.type in (1,2) "
				+ "order by q.seq asc";

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

	public List getoptListByQuestionId(int id) {
		final String sql = "select b.id id,b.name name,b.seq seq,b.score score,b.questionId questionId,a.total countNum "+ 
		"from (select o.id id,nvl(c.countNum,0)total from t_sv_option o,(select op.id id,count(1) countNum from t_sv_option_answer t,t_sv_option op "+
		"where t.option_id = op.id group by op.id)c "+

		"where o.id = c.id(+)) a , "+
		"(select p.ID id, p.NAME name, p.SEQ as seq,p.SCORE score,p.QUESTION_ID questionId "+
				"from T_SV_OPTION p "+
				"order by p.SEQ asc) b "+

		"where a.id = b.id " +
		"and b.questionid ="+id;

		List list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createSQLQuery(sql)
							.setResultTransformer(
									new IgnoreCaseTransformer(
											Option.class)).list();
				}
			});
		return list;
	}

	public List getRightOption(int questionId) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().find(
				"from Option o where o.score = 1 and o.questionId = " + questionId );
		return list;
	}

	public int getCountNumById(int id) {
		List oplist = this.getHibernateTemplate().find("from OptionAnswer oa where oa.optionId="+id );
		return oplist.size();
	}

	public List getOptListByQuestionIdAndMissionId(int id, int missionId) {
		final String sql = "select b.id id,b.name name,b.seq seq,b.score score,b.questionId questionId,a.total countNum "+ 
		"from (select o.id id,nvl(c.countNum,0)total from t_sv_option o," +
		"		(select op.id id,count(1) countNum " +
		"		from t_sv_option_answer t,t_sv_option op,t_sv_answer an "+
				"where t.option_id = op.id " +
				"and t.answer_id = an.id " +
				"and an.mission_id = " + missionId + 
				" group by op.id)c "+
				"where o.id = c.id(+)) a , "+
				"(select p.ID id, p.NAME name, p.SEQ as seq,p.SCORE score,p.QUESTION_ID questionId "+
						"from T_SV_OPTION p "+
						"order by p.SEQ asc) b "+
						"where a.id = b.id " +
						"and b.questionid ="+id;

	List list = this.getHibernateTemplate().executeFind(
		new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createSQLQuery(sql)
						.setResultTransformer(
								new IgnoreCaseTransformer(
										Option.class)).list();
			}
		});
	return list;
	}

	public List getTextAnswer(int id, int missionId) {
		// TODO Auto-generated method stub

	final String sql = "select ta.answer_id answerId,ta.text text,a.mission_id missionId,a.question_id questionId "+
		"from t_sv_text_answer ta,t_sv_answer a " +
		"where ta.answer_id = a.id "+
		"and a.mission_id = "+ missionId +
		"and a.question_id = "+id;

	List list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createSQLQuery(sql)
							.setResultTransformer(
									new IgnoreCaseTransformer(
											TextAnswer.class)).list();
				}
			});

	return list;
	}

	public List getTextAnswersByQuestionId(int questionId) {
		// TODO Auto-generated method stub
		final String sql = "select t.text text,u.real_name realName,o.full_name fullName,a.question_id questionId,q.name questionName "+
				"from t_sv_text_answer t,t_sv_answer a,t_sv_mission m,t_um_user u,t_um_organ o,t_sv_question q "+
				"where t.answer_id = a.id "+
				"and a.mission_id = m.id "+
				"and m.user_id = u.um_user_id "+
				"and u.um_organ = o.um_organ_id "+
				"and a.question_id = q.id "+
				"and a.question_id = "+questionId;

		List list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createSQLQuery(sql)
							.setResultTransformer(
									new IgnoreCaseTransformer(
											TextAnswer.class)).list();
				}
			});

		return list;
	}
	
	public List getAllQuestionsBySurveyId(int surveyId) {
		final String sql = "select s.id surveyId ,s.name surveyName,q.name questionName,q.seq questionSeq,q.id questionId "
				+ "from t_sv_survey s,t_sv_question q "
				+ "where s.id = q.survey_id " 
				+ "and s.id = " + surveyId
				+ "order by q.objseq asc , q.seq asc";

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

	public List getViewSurveyOptList(int id) {
		// TODO Auto-generated method stub
		final String sql = "select b.id id,b.name name,b.seq seq,b.score score,b.questionId questionId,a.total countNum,round(a.total/d.queTotal,2)*100 percent," +
		"	round(a.total/d.queTotal,2)*100*0.8 tdWidth "+ 
		"from (select o.id id,nvl(c.countNum,0)total from t_sv_option o," +
		"(select op.id id,count(1) countNum from t_sv_option_answer t,t_sv_option op,t_sv_answer aa,t_sv_mission m "+
		"where t.option_id = op.id " +
			"and t.answer_id = aa.id "+
			"and aa.mission_id = m.id "+
			"and m.isclosed = 2 " +
			"group by op.id)c "+

			"where o.id = c.id(+)) a , "+
			"(select p.ID id, p.NAME name, p.SEQ as seq,p.SCORE score,p.QUESTION_ID questionId "+
					"from T_SV_OPTION p "+
					"order by p.SEQ asc) b, "+
					"(select count(1) queTotal,an.question_id questionid from t_sv_answer an,t_sv_mission m "+
						"where an.question_id = "+id + 
						"and an.mission_id = m.id "+
						"and m.isclosed = 2 "+
						"group by an.question_id) d "+
					"where a.id = b.id " +
					"and b.questionid ="+id;

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
						.setResultTransformer(
							new IgnoreCaseTransformer(
									Option.class)).list();
					}
				});
		return list;
	}
	
	
	public List getSendEmailList() {
		// TODO Auto-generated method stub
		final String sql = "  SELECT t.id id,t.survey_id surveyId,t.email email,t.if_send ifSend,t.fcu fcu,t.fcd fcd,t.send_type sendType," +
				" t.if_copy_send ifCopySend,t.copy_send_email copySendEmail,t.mission_id missionId,t.user_id userId " +
				" FROM (SELECT a.* " +
				" FROM t_sv_send_email a where a.if_send = 0 " +
				" ORDER BY a.IF_COPY_SEND desc,fcd)t " +
				" WHERE ROWNUM <= 140";

		List list = this.getHibernateTemplate().executeFind(
			new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					return session.createSQLQuery(sql)
							.setResultTransformer(
									new IgnoreCaseTransformer(
											TSendEmail.class)).list();
				}
			});

		return list;
	}
}
