package com.ulic.ulweb.ulweb2.util;

import java.io.File;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigManager {

	public static Configuration config = null;

	static {
		String propertiesPath = "conf/secure.properties";
		
		try {
			String javaHome = System.getProperty("tomcat.home");
			if (javaHome == null) {
				javaHome = System.getProperty("catalina.home");
			}
			if(javaHome != null){
				propertiesPath = javaHome +"/"+propertiesPath;
			}
			
			config = new PropertiesConfiguration(propertiesPath);
		} catch (ConfigurationException e) {
			 System.err.println(" get secure.properties error, "+ propertiesPath);
			 e.printStackTrace();
			 
		}
	}

	public static String getString(String key) {
		return config.getString(key);
	}
	
	public static String getString(String key, String from, String to) {
		String str = config.getString(key);
		if (str != null) {
			str = str.replace(from, to);
		}
		return str;
	}

	public static int getInt(String key) {
		return config.getInt(key);
	}

	public static File getUploadFile(){
		String store_path = ConfigManager.config.getString("upload_dir");
		File dir = new File(store_path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		return dir;
	}
	
	public static String getHistoryColumId(){
		String historyColumId = ConfigManager.config.getString("history_id");
		return historyColumId;
	}
	
	
	public static File getPublishFile(){
		String Store_path = ConfigManager.config.getString("publish_dir");
//		String Store_path = "D:/publish";
		File dir = new File(Store_path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		return dir;	
	}
	
	public static String getUploadPath(){
		return ConfigManager.config.getString("upload_dir");
	}
	
	public static String getCreatePolicyUsername(){
		return config.getString("createPolicyUsername");
	}
	
	public static String getCreatePolicePassword(){
		return config.getString("createPolicypasword");
	}
	
	public static String getViewPolicyUsername(){
		return config.getString("viewPolicyusername");
	}
	
	public static String getViewPolicyPassword(){
		return config.getString("viewPolicypassword");
	}
}
