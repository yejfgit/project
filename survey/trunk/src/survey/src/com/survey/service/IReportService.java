package com.survey.service;

import java.util.List;

public interface IReportService {

	
	/**
	 * 按机构统计分数汇总
	 * @return
	 */
	public List getSealTimesReport(String startDate, String endDate,int deptId,int surveyId);
	
	/**
	 * 下发明细报表
	 * @return
	 */
	public List getRequestDetailList(String startDate, String endDate, int deptId, int surveyId, int surveyStatus);
	
}