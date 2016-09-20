package com.ulic.ulweb.frame.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	public static final ThreadLocal<Connection> conThread = new ThreadLocal<Connection>();
	private ConnectionFactory() {
	}
	public static Connection getConnection() throws SQLException {
		Connection con = conThread.get();
		if (con == null) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:/comp/env/oracle");
				if (ds == null) {
					System.out.print("datasource is null");
				}
				con = ds.getConnection();
				conThread.set(con);
			}
			catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void closeConnection() throws SQLException {
		Connection con = conThread.get();
		conThread.set(null);
		if (con != null) {
			con.close();
		}
	}
	public static void beginTransaction() throws SQLException {
		Connection con = getConnection();
		con.setAutoCommit(false);
	}
	public static void commit() throws SQLException {
		Connection con = conThread.get();
		if (con != null) {
			con.commit();
		}
	}
	public static void rollback() throws SQLException {
		Connection con = conThread.get();
		if (con != null) {
			con.rollback();
		}
	}
}