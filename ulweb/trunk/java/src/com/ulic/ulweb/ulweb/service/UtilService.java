package com.ulic.ulweb.ulweb.service;

import java.sql.SQLException;
import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb.entity.UlConfig;
import com.ulic.ulweb.ulweb.entity.UlDocumentModel;

public interface UtilService extends IService{
	public List getConfigList() throws Exception;
	public int updateConfig(UlConfig c) throws Exception;
	public void add(UlConfig c) throws Exception;
	public UlConfig getById(int id) throws Exception;
	public List getDocumentModelList() throws Exception;
	public UlDocumentModel getDocumentModelById(int id) throws Exception;
	public int editDocumentModle(UlDocumentModel d) throws Exception;
	public void addDocumentModel(UlDocumentModel d) throws Exception;
	public UlConfig getByName(String name) throws Exception;
	public int getCountProcesser(String dept) throws SQLException;
}
