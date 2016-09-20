package com.ulic.ulweb.frame.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ResultNumericalValueCall {
	public abstract int getResultCount(ResultSet rs) throws SQLException;
}
