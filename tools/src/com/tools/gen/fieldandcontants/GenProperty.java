package com.tools.gen.fieldandcontants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.tools.gen.common.MyCon;
import com.tools.gen.fieldandcontants.TableNames.TableName;
/**
 * 生成DTO
 * @author zhengliexin 2011-8-11
 *
 */
public class GenProperty {

	private static TableName tabname =  TableName.PT_JHGNHB;
	private static final boolean isNeedAllSql = false;
	private static int createType = 3;//1:生成get,set方法,2:将表的属性生成NET常量 3:将表的属性生成JAVA常量

	/**
	 * @param args
	 * create : zhenglieixn 2011-8-10
	 * update : zhenglieixn 2011-8-10
	 */
	public static void main(String[] args) {
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = con.createStatement();
			String sql = "select * from "+ tabname;
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			if(isNeedAllSql) System.out.println("select ");

			Map map = GenProperty.getComMap();

			if(createType == 1){
				tableFieldNameGetSetMethod(rsmd,map);
			}else if(createType == 2){
				//生成NET常量
				tableFieldNameToNetConst(rsmd,map);
			}else if(createType == 3){
				//生成JAVA常量
				tableFieldNameToJavaStatic(rsmd,map);
			}



			if(isNeedAllSql) System.out.println("from "+ tabname);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
	}

	/**
	 * 生成表中属性的get set方法
	 * 
	 * @param rsmd
	 * @param map
	 * @throws SQLException
	 */
	public static void tableFieldNameGetSetMethod(ResultSetMetaData rsmd,Map map ) throws SQLException{
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {

			String dbType = rsmd.getColumnTypeName(i);
			String type = "";

			if("varchar2".equalsIgnoreCase(dbType) || "char".equalsIgnoreCase(dbType)){

				type = "String";

			}else if("number".equalsIgnoreCase(dbType)){

				type = "decimal";

			}else{
				type = "unknow type";
			}

			System.out.println("/**"+ (map.get(i) == null ? "   " : map.get(i))+"*/");
			System.out.println("private "+ type +" " 
					+tabname.toString().toLowerCase() 
					+  "_" +rsmd.getColumnName(i).toLowerCase()+";");
			
			System.out.println(rsmd.getTableName(i));
			
		}
	}

	/**
	 * net将表的列表生成常量
	 * 
	 * 
	 */
	public static void tableFieldNameToNetConst(ResultSetMetaData rsmd,Map map ) throws SQLException{
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {

			System.out.println("/**"+map.get(i)+"*/");
			System.out.println("public const string "
					+tabname.toString().toUpperCase()
					+  "_" +rsmd.getColumnName(i)+"=" +'"' +tabname.toString().toUpperCase() 
					+  "_" +rsmd.getColumnName(i)+'"'+";");
		}

	}
	
	/**
	 * Java将表的列表生成常量
	 * 
	 * 
	 */
	public static void tableFieldNameToJavaStatic(ResultSetMetaData rsmd,Map map ) throws SQLException{
		
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {

			System.out.println("/**"+map.get(i)+"*/");
			System.out.println("public final static String "
					+tabname.toString().toUpperCase()
					+  "_" +rsmd.getColumnName(i)+"=" +'"' +tabname.toString().toUpperCase() 
					+  "_" +rsmd.getColumnName(i)+'"'+";");
		}

	}
	
	@SuppressWarnings("unchecked")
	public static Map getComMap(){

		Map map = new HashMap();
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;
		String comSql = "select comments from ALL_COL_COMMENTS where table_name= '"+ tabname + "'";
		
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery(comSql);

			int i = 1;
			while (rs.next()) {

				map.put(i, rs.getString(1));
				i++;
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return map;
	}

}
