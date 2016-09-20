package com.ulic.ulweb.ulweb2.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ParseStringUtil {

	private static final Log log = LogFactory.getLog(ParseStringUtil.class);
	
	public static Map<String, String> parseStringToMap(String str){
		Map<String, String> map = new HashMap<String, String>();
		try{
			if(str != null){
				str = str.replace("；", ";");
//				str = str.replace("=", "=");
				String[] s1 = str.split(";");
				for(int i = 0 ; i< s1.length; i++){
					String[] s2 = s1[i].split("=");
					map.put(s2[0],s2[1]);
				}
		}
		}catch(Exception e){
			log.info("+++++++ParseStringUtil: parseStringToMap exception, please check input string. ");
		}
		return map; 
	}
	
	
	
}
