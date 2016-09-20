package com.survey.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * 根据Spring数据源获得数据库连接
 * @author wengxf
 *
 */
public class DataSourceUtil {
	private static String DATA_SOURCE_NAME = "dataSource";

	/**
	 * 得到连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		DataSource ds = (DataSource) ServiceLocator.getService(DATA_SOURCE_NAME);
		return ds.getConnection();
	}
}
