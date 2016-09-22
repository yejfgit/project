package com.tools.gen.fieldandcontants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.tools.gen.common.MyCon;
import com.tools.gen.fieldandcontants.MobileTableNames.TableName;

/**
 * 生成需要表的属性
 * @author zhengliexin 2011-8-16
 *
 */
public class GenAllSrc {

	//要生成的位置
	private final static String toPath_pro = "F:\\startWordSpace\\YILZ_HIS_TransObj_JAR\\src\\";
	private final static String toPath_file = "com\\yilz\\his\\model\\viewmod";
	
	
	/**
	 * @param args
	 * create : zhenglieixn 2011-8-10
	 * update : zhenglieixn 2011-8-10
	 */
	public static void main(String[] args) {
		
		for (TableName tab : TableName.values()) {
			
			System.out.println("gen table "+ tab +"  now......");
			
			GenAllSrc g = new GenAllSrc();
			g.writeFile(tab,g.genSrcAction(tab));
			
			System.out.println("gen table "+ tab +"  end\n");
		}
		
		System.out.println("gen finished ......");
	}

	private StringBuffer genSrcAction(TableName tabname){
		
		StringBuffer sb = new StringBuffer();
		
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;
		try {

			stmt = con.createStatement();
			String sql = "select * from "+ tabname;
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			String tabCom = this.getTabMap(tabname);
			Map map = this.getComMap(tabname);
			
			sb.append("package "+toPath_file.replace("\\", ".")+";\n\n");
			sb.append("/**\n *"+(tabCom != null ? tabCom : "")+"\n */\n");
			sb.append("public class  "+ classNameStly(tabname) + "{\n");
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				
				sb.append("\t/**"+(map.get(rsmd.getColumnName(i)) != null ? map.get(rsmd.getColumnName(i)):"   ")+"*/\n");
//				sb.append("\tpublic final static String "
//						+tabname.toString().toUpperCase()
//						+  "_" +rsmd.getColumnName(i)+"=" +'"' +tabname.toString().toUpperCase() 
//						+  "_" +rsmd.getColumnName(i)+'"'+";\n");
				
				sb.append("\tpublic final static String "
						+rsmd.getColumnName(i)+"=" +'"' +tabname.toString().toUpperCase() 
						+  "_" +rsmd.getColumnName(i)+'"'+";\n");
			}
			sb.append("\n}");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return sb;
	}

	
	
	@SuppressWarnings("unchecked")
	private Map getComMap(TableName tabname){

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
	
	
	private void writeFile(TableName className,StringBuffer context){
		
		  File desFile = new File(toPath_pro +toPath_file+"\\"+classNameStly(className)+".java");
		  try {
			  
			  FileWriter desWriter = new FileWriter(desFile);
			  desWriter.write(context.toString());
			  desWriter.close();
		   
		  } catch (IOException e) {
			  e.printStackTrace();
		  }
	}
	
	private static String classNameStly(TableName name){
		
		String resStr = "";
		
		resStr = "T_" + name.toString().replace("_", "").toLowerCase();
		
		return resStr;
	}
	
	private String getTabMap(TableName tabname){
		
		String resStr = "";
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;
		String comSql = "select comments from ALL_TAB_COMMENTS where table_name='"+tabname+"'";
		
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery(comSql);

			while (rs.next()) {

				resStr = rs.getString(1);
			}	

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return resStr;
		
	}
	
}
