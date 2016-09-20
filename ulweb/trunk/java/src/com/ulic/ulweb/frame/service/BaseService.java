package com.ulic.ulweb.frame.service;

import java.sql.SQLException;
import com.ulic.ulweb.frame.dao.ConnectionFactory;

public class BaseService {
	protected void beginTransaction() throws SQLException {
		ConnectionFactory.beginTransaction();
	}
	protected void commit() throws SQLException {
		ConnectionFactory.commit();
	}
	protected void rollback() throws SQLException {
		ConnectionFactory.rollback();
	}
	protected void closeConnection() throws SQLException {
		ConnectionFactory.closeConnection();
	}
}