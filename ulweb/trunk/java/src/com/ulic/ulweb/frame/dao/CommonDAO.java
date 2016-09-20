package com.ulic.ulweb.frame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

public class CommonDAO {
	public  Connection getConnection() throws SQLException{
	    String url = "jdbc:oracle:thin:@10.18.1.115:1527:hruat";
	
	    //DriverManager.registerDriver(Class.forName("oracle.jdbc.driver.OracleDriver"));
	    Connection conn = null;
	    try{
	      DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
	       conn = DriverManager.getConnection(url,"umdev","umdev0613");
	    }catch (SQLException e){
	        throw e;
	    }
	    return conn;
	}
}
