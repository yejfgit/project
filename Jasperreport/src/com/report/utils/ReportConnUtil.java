package com.report.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.auxgroup.his.framework.common.reflect.ApplicationStartIni;

public class ReportConnUtil {

	private static Connection con;

	public static Connection getConnection() throws SQLException {

		if (null == con) {
			
			ApplicationContext context = ApplicationStartIni.context;
			JdbcTemplate obj = (JdbcTemplate) context.getBean("jdbcTemplate");
			con = obj.getDataSource().getConnection();
		}
		return con;
	}
}
