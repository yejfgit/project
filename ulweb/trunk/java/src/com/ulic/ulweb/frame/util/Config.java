package com.ulic.ulweb.frame.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.ulic.ulweb.frame.constant.Constant;

public class Config {
	public static void loadConfig(String confName) {
		InputStream in = Config.class.getClassLoader().getResourceAsStream(confName);
		Properties p = new Properties();
		try {
			p.load(in);
			String uploadFilePath = p.getProperty("uploadfilepath");
			Constant.SAVEPATH = uploadFilePath;
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}