package com.ulic.ulweb.ulweb2.dao;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;

public interface IContentTmplDao extends IService {

	List findAll();

	boolean save(ContentTmplEntity ct);

	ContentTmplEntity getById(int id);

	boolean update(ContentTmplEntity ct);

	boolean delete(ContentTmplEntity ct);


}
