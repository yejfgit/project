package com.survey.dao.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.survey.dao.IReportDao;
import com.survey.util.IgnoreCaseTransformer;
import com.survey.vo.Mission;
import com.survey.vo.ReportTimesVO;

public class ReportDaoImpl extends BaseDao implements IReportDao {

	public List getTimesList(String startDate, String endDate, int deptId,
			int surveyId) {

		StringBuffer sb = new StringBuffer();
		sb
				.append("select d.full_name deptFullName,u.real_name userRealName,"
						+ "m.total_score totalScore,s.name surveyName "
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
						+ "and m.begin_time > to_date('"
						+ startDate
						+ "', 'YYYY-MM-DD') "
						+ "and m.finish_time < to_date('"
						+ endDate
						+ "','YYYY-MM-DD') + 1");
		;

		final String sql = sb.toString();

		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createSQLQuery(sql)
								.setResultTransformer(
										new IgnoreCaseTransformer(
												ReportTimesVO.class)).list();
					}
				});

		return list;
	}

}
