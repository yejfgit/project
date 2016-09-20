package com.ulic.ulweb.ulweb2.dao;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ColumnEntity;

public interface IColumnDao extends IService {

	List findAll();

	ColumnEntity getById(int id);

	boolean delete(ColumnEntity d);

	boolean save(ColumnEntity c);

	boolean update(ColumnEntity c);

	List findByProperties(String[] paramNames, Object[] values);



}
