package com.ulic.ulweb.frame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao {
/*	public static IDao getDAO(String DAOName) {
		if (DAOName.equals("pcontentDAO")) {
			return (IDao) new PContentDAO();
		}
		return null;
	}
	
*/
	private Connection getConnection() throws SQLException {
		return ConnectionFactory.getConnection();
	}
	protected PreparedStatement getPreparedStatement(String sqlString) throws SQLException {
		return getConnection().prepareStatement(sqlString);
	}
	protected PreparedStatement getPreparedStatement(String sqlString, int page, int pageSize)
			throws SQLException {
		int max, min;
		min = (page - 1) * pageSize;
		max = page * pageSize;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM ");
		sb.append("(SELECT A.*, ROWNUM RN FROM (");
		sb.append(sqlString);
		sb.append(") A WHERE ROWNUM <=" + String.valueOf(max));
		sb.append(")WHERE RN > " + String.valueOf(min));
		return getConnection().prepareStatement(sb.toString());
	}
	private void destoryResource(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
	private void destoryResource(PreparedStatement pstm, ResultSet rs) {
		if (pstm != null) {
			try {
				pstm.close();
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (rs != null) {
			try {
				rs.close();
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
	protected void execute(PreparedStatement pstm) throws SQLException {
		try {
			pstm.execute();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw  e;
		}
		finally {
			this.destoryResource(pstm);
		}
	}
	protected int executeUpdate(PreparedStatement pstm) throws SQLException {
		int flag = 0;
		try {
			flag = pstm.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw  e;
		}
		finally {
			this.destoryResource(pstm);
		}
		return flag;
	}
	protected Object getObject(PreparedStatement pstm, ResultObjectCall objCall) throws SQLException {
		Object obj = null;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = objCall.getResultObject(rs);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return obj;
	}
	
	protected Object getObjectCanBeNull(PreparedStatement pstm, ResultObjectCall objCall) throws SQLException {
		Object obj = null;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
				obj = objCall.getResultObject(rs);
			}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return obj;
	}
	
	protected Timestamp getTimestampValue(PreparedStatement pstm) throws SQLException {
		Timestamp num =null;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			if (rs.next()) {
				num = rs.getTimestamp(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return num;
	}
	protected int getNumericalValue(PreparedStatement pstm) throws SQLException {
		int num = 0;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return num;
	}
	protected String getStringValue(PreparedStatement pstm) throws SQLException {
		String str = null;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			if (rs.next()) {
				str = rs.getString(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return str;
	}
	protected boolean hasObject(PreparedStatement pstm) throws SQLException {
		boolean flag = false;
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return flag;
	}
	protected List executeQuery(PreparedStatement pstm, ResultObjectCall rsObjCall) throws SQLException {
		List<Object> list = new ArrayList<Object>();
		ResultSet rs = null;
		try {
			rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(rsObjCall.getResultObject(rs));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			this.destoryResource(pstm, rs);
		}
		return list;
	}
}