package com.ulic.ulweb.ulweb2.service.impl;

import java.util.List;

import com.ulic.ulweb.ulweb2.dao.IContentTmplDao;
import com.ulic.ulweb.ulweb2.entity.ContentTmplEntity;
import com.ulic.ulweb.ulweb2.service.IContentTmplService;

public class ContentTmplService implements IContentTmplService {
	private IContentTmplDao contentTmplDao;

	public void setContentTmplDao(IContentTmplDao contentTmplDao) {
		this.contentTmplDao = contentTmplDao;
	}

	public List getAllTmpls() {

		return contentTmplDao.findAll();
	}

	public boolean saveTmpl(ContentTmplEntity ct) {

		return contentTmplDao.save(ct);
	}

	public ContentTmplEntity getTmplById(int id) {
		
		return contentTmplDao.getById(id);
	}

	public boolean updateTmpl(ContentTmplEntity ct) {

		return contentTmplDao.update(ct);
	}

	public boolean delTmplById(int id) {
		
		ContentTmplEntity ct = this.getTmplById(id);
		if (ct == null) {
			return false;
		} else {
			return contentTmplDao.delete(ct);
		}
	}



	
}
