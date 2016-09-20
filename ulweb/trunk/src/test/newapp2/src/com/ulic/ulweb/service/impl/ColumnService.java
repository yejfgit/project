package com.ulic.ulweb.service.impl;

import com.ulic.ulweb.dao.hibernate.UlColumnDAO;
import com.ulic.ulweb.service.IColumnService;

public class ColumnService implements IColumnService {

	private UlColumnDAO columnDAO;

	public void setColumnDAO(UlColumnDAO columnDAO) {
		this.columnDAO = columnDAO;
	}

}
