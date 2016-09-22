package com.tools.gen.dto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.tools.gen.common.MyCon;
import com.tools.gen.common.ToolsUtils;
import com.tools.gen.dto.DTOModelUseTableNames.TableName;

/**
 * 生成需要表的属性
 * 
 * @author zhengliexin 2011-8-16
 * 
 */
public class GenAllViewDTOModel {

	Map<String, StringBuilder> genSrcAction(TableName tabname) {

		Map<String, StringBuilder> resMap = new HashMap<String, StringBuilder>();

		StringBuilder sb = new StringBuilder();
		StringBuilder netsb = new StringBuilder();

		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = con.createStatement();
			String sql = "select * from " + tabname;
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			/** java **/
			sb.append("package " + MainDTOGen.toPath_file.replace("\\", ".")
					+ ";\n\n");
			sb.append("import java.sql.Date;\n");
			// sb.append("import java.sql.Timestamp;\n");
			sb.append("import java.io.Serializable;\n");
			// sb.append("import java.sql.Blob;\n");
			// sb.append("import java.sql.Clob;\n");
			sb.append("\npublic class  " + classNameStly(tabname)
					+ " implements Serializable {\n");

			/** .net **/
			netsb.append("using System;\n");
			netsb.append("using System.Collections;\n");
			netsb.append("\nnamespace " + MainDTOGen.net_namespace + "\n");
			netsb.append("{\n");
			netsb.append("\t[Serializable]\n");
			netsb
					.append("\tpublic class " + classNameStly(tabname)
							+ "\n\t{\n");

			Map<String, String> getAndSetMap = new LinkedHashMap<String, String>();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {

				int scale = rsmd.getScale(i);
				String key = rsmd.getColumnName(i).toLowerCase();
				int precision = rsmd.getPrecision(i);
				String type = ToolsUtils.getBaseTypeFromClassName(rsmd
						.getColumnClassName(i), scale, precision);

				/** java属性 **/
				sb.append("\n");
				sb.append("\tprivate " + type + " " + key + ";\n");

				getAndSetMap.put(key, type);

				/** .net属性 **/
				netsb.append("\n");
				netsb.append("\t\tprivate " + ToolsUtils.netSpecialHandle(type)
						+ " " + key + ";\n");

			}

			sb.append("\n");
			this.getAndSetGen(sb, getAndSetMap);
			sb.append("\n}");

			netsb.append("\n");
			this.getAndSetGenForNet(netsb, getAndSetMap);
			netsb.append("\n\t}\n}");

			resMap.put("javaContext", sb);
			resMap.put("netContext", netsb);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return resMap;
	}

	
	private StringBuilder getAndSetGen(StringBuilder sb, Map<String, String> map) {

		Iterator<String> keyIterator = map.keySet().iterator();

		while (keyIterator.hasNext()) {

			String key = keyIterator.next();
			String value = map.get(key);

			sb.append("\tpublic " + value + " get" + this.lowerToUp(key)
					+ "(){\n");
			sb.append("\t\treturn " + key + ";\n");
			sb.append("\t}\n");

			sb.append("\tpublic void  set" + this.lowerToUp(key) + "(" + value
					+ " " + key + "){\n");
			sb.append("\t\tthis." + key + " = " + key + ";\n");
			sb.append("\t}\n");
		}

		return sb;
	}

	private StringBuilder getAndSetGenForNet(StringBuilder netsb,
			Map<String, String> map) {

		Iterator<String> keyIterator = map.keySet().iterator();

		while (keyIterator.hasNext()) {

			String key = keyIterator.next();
			String value = map.get(key);

			netsb.append("\t\tpublic " + ToolsUtils.netSpecialHandle(value)
					+ " " + this.lowerToUp(key) + "\n");
			netsb.append("\t\t{\n");
			netsb.append("\t\t\tget { return " + key + "; }\n");
			netsb.append("\t\t\tset { " + key + " = value; }\n");
			netsb.append("\t\t}\n");
		}
		return netsb;
	}

	void writeFile(TableName className, StringBuilder context) {

		File desFile = new File(MainDTOGen.toPath_file + "\\" + classNameStly(className)
				+ ".java");
		try {

			FileWriter desWriter = new FileWriter(desFile);
			desWriter.write(context.toString());
			desWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	void writeFileForNet(TableName className, StringBuilder context) {

		File desFile = new File(MainDTOGen.toPath_all_net + "\\"
				+ classNameStly(className) + ".cs");
		try {

			FileWriter desWriter = new FileWriter(desFile);
			desWriter.write(context.toString());
			desWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	private static String classNameStly(TableName name) {

		String resStr = "";

		// resStr = name.toString().replace("_", "").toLowerCase()+"DTO";
		resStr = lowerToUp(name.toString().toLowerCase()) + "DTO";

		return resStr;
	}
	
	

	private static String lowerToUp(String str) {

		String resStr = str.replaceFirst(str.substring(0, 1), str.substring(0,
				1).toUpperCase());

		return resStr;
	}
	
	
	
	
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>**/
	/***********************************************************************************/
	/***********************************************************************************/
	/**********根据select语句，生成javabean************************************************/
	Map<String, StringBuilder> genSrcAction(String sqlStr,String beanName) {
		Map<String, StringBuilder> resMap = new HashMap<String, StringBuilder>();

		StringBuilder sb = new StringBuilder();
		StringBuilder netsb = new StringBuilder();

		Connection con = MyCon.getCon();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			stmt = con.createStatement();
			String sql =sqlStr;
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();

			/** java **/
			sb.append("package " + MainDTOGen.toPath_file.replace("\\", ".")
					+ ";\n\n");
			sb.append("import java.sql.Date;\n");
			// sb.append("import java.sql.Timestamp;\n");
			sb.append("import java.io.Serializable;\n");
			// sb.append("import java.sql.Blob;\n");
			// sb.append("import java.sql.Clob;\n");
			sb.append("\npublic class  " + lowerToUp(beanName.toLowerCase()+ "DTO")
					+ " implements Serializable {\n");

			/** .net **/
			netsb.append("using System;\n");
			netsb.append("using System.Collections;\n");
			netsb.append("\nnamespace " + MainDTOGen.net_namespace + "\n");
			netsb.append("{\n");
			netsb.append("\t[Serializable]\n");
			netsb
					.append("\tpublic class " + lowerToUp(beanName.toLowerCase()+ "DTO")
							+ "\n\t{\n");

			Map<String, String> getAndSetMap = new LinkedHashMap<String, String>();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {

				int scale = rsmd.getScale(i);
				String key = rsmd.getColumnName(i).toLowerCase();
				int precision = rsmd.getPrecision(i);
				String type = ToolsUtils.getBaseTypeFromClassName(rsmd
						.getColumnClassName(i), scale, precision);

				/** java属性 **/
				sb.append("\n");
				sb.append("\tprivate " + type + " " + key + ";\n");

				getAndSetMap.put(key, type);

				/** .net属性 **/
				netsb.append("\n");
				netsb.append("\t\tprivate " + ToolsUtils.netSpecialHandle(type)
						+ " " + key + ";\n");

			}

			sb.append("\n");
			this.getAndSetGen(sb, getAndSetMap);
			sb.append("\n}");

			netsb.append("\n");
			this.getAndSetGenForNet(netsb, getAndSetMap);
			netsb.append("\n\t}\n}");

			resMap.put("javaContext", sb);
			resMap.put("netContext", netsb);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyCon.cloExc(rs, stmt, con);
		}
		return resMap;
	}
	
	private static String classNameStly(String name) {

		String resStr = "";

		// resStr = name.toString().replace("_", "").toLowerCase()+"DTO";
		resStr = lowerToUp(name.toString().toLowerCase()) + "DTO";

		return resStr;
	}

	void writeFileForNet(String className, StringBuilder context) {

		File desFile = new File(MainDTOGen.toPath_all_net + "\\"
				+ classNameStly(className) + ".cs");
		try {

			FileWriter desWriter = new FileWriter(desFile);
			desWriter.write(context.toString());
			desWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void writeFile(String className, StringBuilder context) {

		File desFile = new File(MainDTOGen.toPath_pro_java
				+ MainDTOGen.toPath_file + "\\" + classNameStly(className)
				+ ".java");
		try {

			FileWriter desWriter = new FileWriter(desFile);
			desWriter.write(context.toString());
			desWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/***********************************************************************************/
	/***********************************************************************************/
	/**<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<**/

}
