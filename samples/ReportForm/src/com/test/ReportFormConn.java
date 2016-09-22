package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReportFormConn {
	
	public static Connection getdbConnection() 
	{
		Connection conn = null;

		try
		{
			//Change these settings according to your local configuration
			String driver = "oracle.jdbc.driver.OracleDriver";
			//String connectString = "jdbc:hsqldb:hsql://localhost";			
			String connectString ="jdbc:oracle:thin:@10.7.200.141:1521:MZYYHYCSK";
			
			//String connectString ="jdbc:oracle:thin://10.7.200.141:1521:MZYYHYCSK";
			String user = "sd_hospital";
			String password = "sd_hospital";


			Class.forName(driver);
			conn = DriverManager.getConnection(connectString, user, password);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		}

		return conn;
	}


}
