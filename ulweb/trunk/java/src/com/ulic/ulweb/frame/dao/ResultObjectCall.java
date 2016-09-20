package com.ulic.ulweb.frame.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ResultObjectCall {
	public abstract Object getResultObject(ResultSet rs) throws SQLException;
}
