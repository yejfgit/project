package com.ulic.ulweb.ulweb.service.impl;

import java.util.List;

import com.ulic.ulweb.ulweb.dao.UlReportDAO;
import com.ulic.ulweb.ulweb.entity.UlReport;
import com.ulic.ulweb.ulweb.service.IUlReportService;

public class UlReportServiceImpl implements IUlReportService{
	private UlReportDAO reportDAO = new UlReportDAO();	

	public UlReportDAO getReportDAO() {
		return reportDAO;
	}

	public void setReportDAO(UlReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	public void save(UlReport report) throws Exception {
		// TODO Auto-generated method stub
		reportDAO.add(report);
	}
	
	public List getAllReport() throws Exception{
		return reportDAO.getAllReport();
	}

	public UlReport getReport() throws Exception {
		// TODO Auto-generated method stub
		return reportDAO.getReport();
	}
}
