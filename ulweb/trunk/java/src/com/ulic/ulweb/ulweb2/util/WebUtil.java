package com.ulic.ulweb.ulweb2.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.ulweb.web.action.IndexAction;

public class WebUtil {

	/**
	 * 获得指定URL的页面内容字符串
	 * @param url
	 * @return
	 */
	public static String getHTML(String url) {

		try {
			URL newUrl = new URL(url);
			URLConnection connect = newUrl.openConnection();
			connect.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			connect.setConnectTimeout(5000);
			DataInputStream dis = new DataInputStream(connect.getInputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(dis,
					"UTF-8"));
			StringBuffer html = new StringBuffer();
			String readLine = null;
			while ((readLine = in.readLine()) != null) {
				html.append(readLine);
				html.append("\n");
			}
			in.close();
			return html.toString();

		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
			ioe.printStackTrace();
		}
		return null;

	}
	
	/**
	 * 清空所有成员机器的首页缓存
	 *
	 */
	public static void clearAllCache() {
		
		Thread t = new Thread() {
			@Override
			public void run() {

				String urls = ConfigManager.getString("clusterURLs");
				String[] url = urls.split(";");
				for (int i = 0; i < url.length; i++) {
					String u = url[i].trim();
					if ("".equals(u)) {
						continue;
					}
					System.out.println(u);
					getHTML(u + Constant.contextPath + "/index.do?reset=1");
				}


			}
		};
		
		t.start();

	}

}
