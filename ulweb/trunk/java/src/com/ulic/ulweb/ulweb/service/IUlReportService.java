package com.ulic.ulweb.ulweb.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlReport;

public interface IUlReportService extends IService {
	
	public void save(UlReport report) throws Exception;
	public List getAllReport() throws Exception;
	public UlReport getReport() throws Exception;
}
