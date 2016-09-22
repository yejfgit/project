package com.tools.gen.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;

public class ToolsUtils {

	
	public static  String orclTypeToJavaType(String str){
		
		String resStr = str;

		if("varchar2".equalsIgnoreCase(str) || "char".equalsIgnoreCase(str) || "varchar".equalsIgnoreCase(str)){

			resStr = "String";

		}else if("number".equalsIgnoreCase(str)){ 

			resStr = "BigDecimal";

		}else if("bigint".equalsIgnoreCase(str)){ 

			resStr = "Long";

		}else if("smallint".equalsIgnoreCase(str)){ 

			resStr = "BigDecimal";

		}else if("bigint".equalsIgnoreCase(str)){ 

			resStr = "Integer";

		}else if("decimal".equalsIgnoreCase(str)){ 

			resStr = "double";

		}else if("timestmp".equalsIgnoreCase(str)){
				
			resStr = "Timestamp";
			
		}else{
			resStr = "unknow type";
		}
		
		return resStr;
	}
	
	
	public static String getBaseTypeFromClassName(String className,Integer scale,int precision){

		String resStr = className;

		if(StringUtils.isNotBlank(className) && scale != null){
			
			String[] strs = className.split("\\.");
			resStr = strs[strs.length-1];
			
			if(StringUtils.isNotBlank(resStr)){
				
				if("BigDecimal".equalsIgnoreCase(resStr)){
					
					if(scale == 0){
						
						if(precision > 9){
							
							resStr = "Long";
						}else{
							resStr = "Integer";
						}
					}else{
						resStr = "Double";
					}
				}else if("Blob".equalsIgnoreCase(resStr) || "Clob".equalsIgnoreCase(resStr)){
					
					resStr = "byte[]";
				}
				else if("OPAQUE".equalsIgnoreCase(resStr) ){
					resStr = "String";
				}
				else if("Timestamp".equalsIgnoreCase(resStr)){
					resStr = "Date";
				}
			}
		}
		return resStr;
	}
	
	/**
	 * EXTJS 类型
	 * @param className
	 * @param scale
	 * @param precision
	 * @return
	 * @function:
	 * @create : zhengliexin 2012-8-30
	 * @update : zhengliexin 2012-8-30
	 */
	public static String getBaseTypeFromExtjs(String className,Integer scale,int precision){

		String resStr = className;

		if(StringUtils.isNotBlank(className) && scale != null){
			
			String[] strs = className.split("\\.");
			resStr = strs[strs.length-1];
			
			if(StringUtils.isNotBlank(resStr)){
				
				if("BigDecimal".equalsIgnoreCase(resStr)){
					
					if(scale == 0){
						
						if(precision > 9){
							
							resStr = "long";
						}else{
							resStr = "int";
						}
					}else{
						resStr = "double";
					}
				}else if("Blob".equalsIgnoreCase(resStr) || "Clob".equalsIgnoreCase(resStr)){
					
					resStr = "string";
				}
				else if("OPAQUE".equalsIgnoreCase(resStr) ){
					resStr = "string";
				}
				else if("Timestamp".equalsIgnoreCase(resStr)){
					resStr = "string";
				}else if("String".equalsIgnoreCase(resStr)){
					resStr = "string";
				}
			}
		}
		return resStr;
	}
	
	public static void writeFile(StringBuilder context,File desFile){

		try {

			FileWriter desWriter = new FileWriter(desFile);;
			desWriter.write(context.toString());
			desWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * .net和Java的互换
	 * @param str
	 * @return
	 * @create : zhenglieixn 2011-12-28
	 * @update : zhenglieixn 2011-12-28
	 */
	public static String netSpecialHandle(String str){
		
		if("Integer".equalsIgnoreCase(str)){
			str = "int?";
		}else if("Double".equalsIgnoreCase(str)){
			str = "double?";
		}else if("Long".equalsIgnoreCase(str)){
			str = "long?";
		}else if("boolean".equalsIgnoreCase(str)){
			str = "Boolean?";
		}else if("Date".equalsIgnoreCase(str)){
			str = "DateTime";
		}
		return str;
	}
	
	

	
}
