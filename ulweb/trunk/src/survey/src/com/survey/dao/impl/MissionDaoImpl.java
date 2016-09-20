package com.survey.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.survey.dao.IMissionDao;
import com.survey.dao.ISurveyDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.Mission;
import com.survey.vo.MissionVO;
import com.survey.vo.ReportTimesVO;
import com.survey.vo.User;

public class MissionDaoImpl extends HibernateDaoSupport implements IMissionDao { 

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

	public List getUnBeginMission() {
		
		List ublist = this.getHibernateTemplate().find(
		"from Mission m where m.isClosed = 0 ");
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




}
