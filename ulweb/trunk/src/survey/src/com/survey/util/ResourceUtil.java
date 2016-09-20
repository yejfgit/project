package com.survey.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceUtil {
	
	private static ResourceUtil res = null;
	
	private static Properties prop = null;
	
	private ResourceUtil() {
		System.out.println("====================load properties");
		try {
			prop = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("survey.properties");
			prop.load(is);
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 初始化本资源类，读取所有的配置参数
	 *
	 */
	public static void getInstance() {
		if (res == null) {
			res = new ResourceUtil();
		}
	}

	public static String getProperty(String key) {
		if (!prop.containsKey(key)) {
			System.err.println("properties: " + key + " is not exists.");
		}
		return prop.getProperty(key);
	}
	
	public static int getIntProperty(String key) {

		return Integer.parseInt(getProperty(key));
	}
	
	/**
	 * 仅用于单元测试
	 * @param ps
	 */
	public static void setProperties(Properties ps) {
		prop = ps;
	}

	
	
}
