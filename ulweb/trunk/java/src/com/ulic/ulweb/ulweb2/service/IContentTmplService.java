package com.ulic.ulweb.ulweb2.service;

import java.util.List;

import com.ulic.ulweb.frame.service.IService;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;

public interface IContentTmplService extends IService {

	List getAllTmpls();

	boolean saveTmpl(ContentTmplEntity ct);

	ContentTmplEntity getTmplById(int id);

	boolean updateTmpl(ContentTmplEntity ct);

	boolean delTmplById(int id);



}
