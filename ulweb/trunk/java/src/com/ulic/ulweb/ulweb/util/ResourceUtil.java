package com.ulic.ulweb.ulweb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ulic.ulweb.ulweb2.entity.PageEntity;
import com.ulic.ulweb.ulweb2.util.ConfigManager;

public class ResourceUtil {

	private static Logger log = Logger.getLogger(ResourceUtil.class);
	
	/** upload absolute path */
	private static String filesRoot = "";
	
	/** download relative path */
	private static String filesPath = "";

	
	// properties file path
	private static String propertiesPath = "";

	public static boolean initUlwebProperties() {
		
		String javaHome = System.getProperty("tomcat.home");
		if (javaHome == null) {
			javaHome = System.getProperty("catalina.home");
		}
		propertiesPath = javaHome + "/conf/secure.properties";

		
		Properties p = new Properties();
		InputStream in;
		try {
			log.debug((new File(propertiesPath)).getAbsolutePath());
			in = new BufferedInputStream(new FileInputStream(propertiesPath));
			p.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.err.println("properties not found.");
			return false;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			log.debug("properties cannot be loaded.");
			return false;
		}
		String filesDir = p.getProperty("upload");
		if (filesDir != null) {
			//log.debug(filesDir);
			filesRoot = filesDir;
		}
		String filesPathDir = p.getProperty("download");
		if (filesPathDir != null) {
			//log.debug(filesDir);
			filesPath = filesPathDir;
		}

		return true;
	}
	
	
	public static String getFilesRootDir() {
		return ConfigManager.getUploadPath() + "/";
	}
	
	public static String getFilesPathDir() {
		return filesPath;
	}

	public static void downloadFile(HttpServletRequest req, HttpServletResponse resp,
			String filePath) throws IOException {

		File f = new File(ConfigManager.getUploadPath(), filePath);
		log.info(f.getAbsolutePath());
		if (!f.exists()) {
			resp.getOutputStream().println("file not found");
			return;
		}

		InputStream is = new BufferedInputStream(new FileInputStream(f));
		
		byte[] content = null;
		if (is.available() > 0) {
			content = new byte[is.available()];
			is.read(content);
		} else {
			resp.getOutputStream().println("file has no size");
			return;
		}

		ServletOutputStream out = resp.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);

		bos.write(content, 0, content.length);
		bos.flush();
		bos.close();

		
	}

}
