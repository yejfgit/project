package com.survey.service.impl;

import java.util.List;

import com.survey.dao.IDeptDao;
import com.survey.dao.IReportDao;
import com.survey.dao.impl.BaseDao;
import com.survey.service.IReportService;
import com.survey.vo.RequestDetailVO;
import com.survey.vo.SurveyVO;



public class ReportServiceImpl implements IReportService {

	private IReportDao reportDao;
	
	private BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public void setReportDao(IReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public List getSealTimesReport(String startDate, String endDate,int deptId,int surveyId)  {
		
		List list = reportDao.getTimesList(startDate, endDate, deptId,surveyId);
		
		return list;
	}

	public List getRequestDetailList(String startDate, String endDate, int deptId, int surveyId, int surveyStatus) {
		
		String sql = "select case when instr(deptName, '公司', -1) = 0 then deptName " +
				"else substr(deptName, 0, instr(deptName, '公司', -1) + 1) end deptName, " +
				"to_char(reqDate, 'yyyy-mm-dd') reqDate, userName userName, " +
				"sum(total) total, sum(done) done, sum(todo) todo, sum(closed) closed, sum(invalid) invalid " +
				" from (" +
				"select uo.full_name deptName, trunc(m.request_time, 'dd') reqDate, " +
				"uu.real_name userName," +
				"1 total, " +
				"decode(m.isclosed, 2, 1, 0) done, " +
				"decode(m.isclosed, 1, 1, 0) todo, " +
				"decode(m.isclosed, 3, 1, 0) closed, " +
				"decode(m.isclosed, 4, 1, 0) invalid " +
				"from t_sv_mission m, t_um_user uu, t_um_organ uo " +
				"where m.user_id = uu.um_user_id " +
				"and uu.um_organ = uo.um_organ_id ";
				
		if (startDate != null) {
			sql += "and m.request_time >= to_date('" + startDate + "', 'yyyy-mm-dd') ";
		}
		if (endDate != null) {
			sql += "and m.request_time <= to_date('" + endDate + "', 'yyyy-mm-dd') + 1 ";
		}
		if (deptId != 0) {
			sql += "and uo.um_organ_id in (select a.um_organ_id from ( "
						+ "select d.um_organ_id , d.full_name , "
						+ "parent_id  "
						+ "from t_um_organ d "
						+ "connect by prior um_organ_id = parent_id start with um_organ_id in ('"
						+ deptId
						+ "')) a )  ";
		}
		if (surveyId != 0) {
			sql += "and m.survey_id = " + surveyId + " ";
		}
		if (surveyStatus != -1) {
			sql += "and m.isclosed = " + surveyStatus + " ";
		}
				
		sql += ") group by deptName, reqDate, userName " +
				"order by deptName asc, reqDate asc ";
		
		List list = baseDao.getList(sql, RequestDetailVO.class);
	
		return list;
	}
	
}
