package com.tools.gen.fieldandcontants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.tools.gen.common.MyCon;
import com.tools.gen.fieldandcontants.TableNames.TableName;
/**
 * �ֶ�����
 * @author zhengliexin 2011-8-10
 *
 */
public class GenBaseSql {
	//����
	private static TableName tabname =  TableName.VW_BQ_YPYZJE;
	//�Ƿ���Ҫ������SQL��ѯ���
	private static final boolean isNeedAllSql = false;
	//�Ƿ���Ҫ��ʾע��
	private static final boolean isNeedMark = false;
	/**
	 * @param args
	 * create : zhenglieixn 2011-8-10
	 * update : zhenglieixn 2011-8-10
	 */
	public static void main(String[] args) {
		
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {

			stmt = con.createStatement();
			
			String sql = "select * from "+ tabname;
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			Map map = new LinkedHashMap();
			if(isNeedMark)  map = GenBaseSql.getComMap();
			
			if(isNeedAllSql) System.out.println("select ");
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				String mark = "";
				if(isNeedMark) mark = (map.get(rsmd.getColumnName(i))==null)?"  ":("--" + map.get(rsmd.getColumnName(i)).toString()); 
				
				System.out.print(rsmd.getColumnName(i) +","+ mark);
			}
			
			if(isNeedAllSql) System.out.println("from "+ tabname);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static Map getComMap(){

		Map map = new HashMap();
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;
		String comSql = "select comments,column_name from ALL_COL_COMMENTS where table_name= '"+ tabname + "'";
		
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery(comSql);

			while (rs.next()) {

				map.put(rs.getString(2), rs.getString(1));
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return map;
	}
}
