package com.tools.gen.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyCon {

	
	public static Connection getCon(){
		
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//			String url = "jdbc:oracle:thin:@192.168.0.211:1521:ylzhis";
//			String url = "jdbc:oracle:thin:@192.168.0.238:1521:ylzhis";
//			String url = "jdbc:oracle:thin:@192.168.0.238:1521:emrv3all";
//			String url = "jdbc:oracle:thin:@129.1.20.15:1521:ylzhis";
//			String url = "jdbc:oracle:thin:@192.168.0.238:1521:ylztest";
//			String url = "jdbc:oracle:thin:@192.168.0.238:1521:EMRV3ALL";
			//String url = "jdbc:oracle:thin:@192.168.0.238:1521:DZBL";
			//String url = "jdbc:oracle:thin:@193.168.1.19:1521:DZBLV3";
			//String url = "jdbc:oracle:thin:@193.168.1.19:1521:EmrV3";
			//String url = "jdbc:oracle:thin:@193.168.1.4:1521:zhhis";
			
//			con = DriverManager.getConnection(url, "sd_hospital", "hellofjrmyy");
			con = DriverManager.getConnection(url, "sd_hospital", "sd_hospital");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void cloExc(ResultSet rs,Statement stmt,Connection con){
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
