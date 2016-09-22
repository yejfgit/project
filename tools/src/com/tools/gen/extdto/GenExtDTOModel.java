package com.tools.gen.extdto;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tools.gen.common.ToolsUtils;
/**
 * 生成需要表的属性
 * @author zhengliexin 2011-8-16
 *
 */
public class GenExtDTOModel {
	
	
	void genJavaCode(Object[][] keyValues){
		
		if(keyValues != null && keyValues.length > 1){
			
			Map<String,String> map = new LinkedHashMap<String, String>();
			Map<String,String> commentMap = new LinkedHashMap<String, String>();
			
			String curDTOName = String.valueOf(keyValues[0][0]);
			String superDTOName = String.valueOf(keyValues[0][1]);
			
			for (int i = 1; i < keyValues.length; i++) {
				
				String type = String.valueOf(keyValues[i][0]);
				String property = String.valueOf(keyValues[i][1]);
				if(null != keyValues[i][2] ){
					String comment = String.valueOf(keyValues[i][2]);
					commentMap.put(property, comment);
				}
				map.put(property,type);
				
			}
			
			StringBuilder context = _genJavaCode(curDTOName, superDTOName, map,commentMap);
			
			File desFile = new File(MainExtDTOGen.toPath_pro_java + MainExtDTOGen.toPath_extfile+"\\"+curDTOName+".java");
			ToolsUtils.writeFile(context, desFile);
		}
	}
	
	

	
	private StringBuilder _genJavaCode(String curDTOName,String superDTOName, Map<String,String> map,Map<String,String> commentMap){
		
		StringBuilder sb = new StringBuilder();
		
		if(!map.isEmpty() && StringUtils.isNotBlank(curDTOName)){
			
			sb.append("package "+MainExtDTOGen.toPath_extfile.replace("\\", ".")+";\n\n");
			sb.append("import java.io.Serializable;\n");
			
			if(StringUtils.isNotBlank(superDTOName)){
				
				sb.append("import "+ MainExtDTOGen.toPath_file.replace("\\", ".") + "."+ superDTOName+";\n");
				sb.append("\npublic class  "+ curDTOName + " extends " + superDTOName + " implements Serializable {\n");
				
			}else{
				sb.append("\npublic class  "+ curDTOName + " implements Serializable {\n");
			}
			
			Iterator<String> keyIterator = map.keySet().iterator();
			
			while(keyIterator.hasNext()){
				
				String key = keyIterator.next();
				String type = map.get(key);
				
				sb.append("\n");
				sb.append("\t/** "+ commentMap.get(key) +"**/\n");
				sb.append("\tprivate " + type +" "+ key.toLowerCase() +";\n");
			}
			
			sb.append("\n");
			javaGetAndSetGen(sb, map);
			sb.append("\n}");
		}
		
		return sb;
	}
	
	private StringBuilder javaGetAndSetGen(StringBuilder sb,Map<String, String> map){
		
		Iterator<String> keyIterator = map.keySet().iterator();
		
		while(keyIterator.hasNext()){
			
			String key = keyIterator.next();
			String value = map.get(key);
			
			sb.append("\tpublic "+ value +" get" + this.lowerToUp(key.toLowerCase()) + "(){\n");
			sb.append("\t\treturn " + key.toLowerCase() + ";\n");
			sb.append("\t}\n");
			
			sb.append("\tpublic void  set" + this.lowerToUp(key.toLowerCase()) +"("+ value + " " + key.toLowerCase()  + "){\n");
			sb.append("\t\tthis." + key.toLowerCase() +" = " + key.toLowerCase() +";\n");
			sb.append("\t}\n");
		}
		
		return sb;
	}
	
	void genNetCode(Object[][] keyValues){
		
		if(keyValues != null && keyValues.length > 1){
			
			Map<String,String> map = new LinkedHashMap<String, String>();
			Map<String,String> commentMap = new LinkedHashMap<String, String>();
			
			String curDTOName = String.valueOf(keyValues[0][0]);
			String superDTOName = String.valueOf(keyValues[0][1]);
			
			for (int i = 1; i < keyValues.length; i++) {
				
				String type = String.valueOf(keyValues[i][0]);
				String property = String.valueOf(keyValues[i][1]);
				if(null != keyValues[i][2] ){
					String comment = String.valueOf(keyValues[i][2]);
					commentMap.put(property, comment);
				}
				
				map.put(property,type);
			}
			
			StringBuilder context = _genNetCode(curDTOName, superDTOName, map,commentMap);
			
			File desFile = new File(MainExtDTOGen.toPath_all_extnet+"\\"+curDTOName+".cs");
			ToolsUtils.writeFile(context, desFile);
		}
	}
	
	
	private StringBuilder _genNetCode(String curDTOName,String superDTOName, Map<String,String> map,Map<String,String> commentMap){
		
		StringBuilder netsb = new StringBuilder();
		
		if(!map.isEmpty() && StringUtils.isNotBlank(curDTOName)){
			
			netsb.append("using System;\n");
			netsb.append("using System.Collections;\n");
			if(StringUtils.isNotBlank(superDTOName)){
				netsb.append("using " + MainExtDTOGen.net_namespace + ";\n");
			}
			netsb.append("\nnamespace " + MainExtDTOGen.netext_namespace + "\n");
			netsb.append("{\n");
			netsb.append("\t[Serializable]\n");
			
			if(StringUtils.isNotBlank(superDTOName)){
				netsb.append("\tpublic class "+ curDTOName + " : " + superDTOName + "\n\t{\n");
			}else{
				netsb.append("\tpublic class "+ curDTOName + "\n\t{\n");
			}
			
			Iterator<String> keyIterator = map.keySet().iterator();
			
			while(keyIterator.hasNext()){
				
				String key = keyIterator.next();
				String type = map.get(key);
				
				netsb.append("\n");
		        /// <summary>
		        /// 
		        /// </summary>
				netsb.append("\t\t/// <summary>\n");
				netsb.append("\t\t/// " + commentMap.get(key) + "\n");
				netsb.append("\t\t/// <summary>\n");
				netsb.append("\t\tprivate " + ToolsUtils.netSpecialHandle(type) +" "+ key.toLowerCase() +";\n");
			}
			
			netsb.append("\n");
			netAndSetGen(netsb, map);
			netsb.append("\n\t}\n}");
		}
		
		return netsb;
	}

	
	
	private StringBuilder netAndSetGen(StringBuilder netsb,Map<String, String> map){
		
		Iterator<String> keyIterator = map.keySet().iterator();
		
		while(keyIterator.hasNext()){
			
			String key = keyIterator.next();
			String value = map.get(key);
			
			netsb.append("\t\tpublic " + ToolsUtils.netSpecialHandle(value) + " " + this.lowerToUp(key) +"\n");
			netsb.append("\t\t{\n");
			netsb.append("\t\t\tget { return " + key.toLowerCase() + "; }\n");
			netsb.append("\t\t\tset { " + key.toLowerCase() + " = value; }\n" );
			netsb.append("\t\t}\n");
		}
		return netsb;
	}
	
	
	
	private static String lowerToUp (String str) {
		
		String resStr =str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase());
		
		return resStr;
	}


	
	
}
