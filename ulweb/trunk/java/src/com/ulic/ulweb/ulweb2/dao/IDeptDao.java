package com.ulic.ulweb.ulweb2.dao;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.DeptEntity;

public interface IDeptDao extends IService {

	List findAll();

	DeptEntity getById(String id);

	boolean delete(DeptEntity d);

	boolean save(DeptEntity d);

	boolean update(DeptEntity d);

}
