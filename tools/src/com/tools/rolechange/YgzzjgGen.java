package com.tools.rolechange;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.tools.gen.common.MyCon;
import com.tools.gen.common.ToolsUtils;
import com.tools.gen.dto.DTOModelUseTableNames.TableName;

public class YgzzjgGen {

	
	
	Map<String,StringBuilder> genSrcAction(TableName tabname,Object[] jsid){

		Map<String,StringBuilder> resMap = new HashMap<String, StringBuilder>();

		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;


		try {

			stmt = con.createStatement();
			String sql = "select * from "+ tabname;
			
			
			rs = stmt.executeQuery(sql);
			
			

		
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return resMap;
	}

	private StringBuilder getAndSetGen(StringBuilder sb,Map<String, String> map){

		Iterator<String> keyIterator = map.keySet().iterator();

		while(keyIterator.hasNext()){

			String key = keyIterator.next();
			String value = map.get(key);

			sb.append("\tpublic "+ value +" get" + this.lowerToUp(key) + "(){\n");
			sb.append("\t\treturn " + key + ";\n");
			sb.append("\t}\n");

			sb.append("\tpublic void  set" + this.lowerToUp(key) +"("+ value + " " + key  + "){\n");
			sb.append("\t\tthis." + key +" = " + key +";\n");
			sb.append("\t}\n");
		}

		return sb;
	}



	private static String lowerToUp (String str) {

		String resStr =str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase());

		return resStr;
	}
	
	
}
