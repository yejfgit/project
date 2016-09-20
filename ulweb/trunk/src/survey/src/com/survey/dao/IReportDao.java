package com.survey.dao;

import java.util.List;


public interface IReportDao {
	
	/**
	 * 根据起止时间和机构名称（总、分公司层级）查询
	 * @param startDate
	 * @param endDate
	 * @param branchNames
	 * @return
	 */
	public List getTimesList(String startDate, String endDate,int deptId,int surveyId);
	
}
