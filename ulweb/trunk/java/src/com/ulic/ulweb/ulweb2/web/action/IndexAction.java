package com.ulic.ulweb.ulweb2.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ulic.ulweb.frame.action.BaseAction;

import com.ulic.ulweb.ulweb2.util.ConfigManager;
import com.ulic.ulweb.ulweb2.util.WebUtil;

public class IndexAction extends BaseAction {

	private static String htmlStr = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		String ptype = this.getStringValue(request, "ptype", "");
		String reset = this.getStringValue(request, "reset", null);
		if (reset != null) {
			clearCache();
			PrintWriter out = response.getWriter();
			out.println("缓存已清空，正在跳转...<script>setTimeout(\"location.href='index.do'\", 1000);</script>");
			return null;
		}
//		else if ("999".equals(reset)) {
//			
//			//WebUtil.getHTML("http://10.53.32.104:8888/newapp/index.do?reset=1");
//			WebUtil.clearAllCache();
//			return null;
//			
//		}
		

		String path = request.getContextPath();
		String basePath = ConfigManager.getString("webURL") + ""
				+ path + "/";
		String url = basePath + "index.jsp";
		//System.out.println("url: " + url);
		
		if (htmlStr == null) {
			log.info("from db");
			htmlStr = WebUtil.getHTML(url);
		} else {
			log.debug("from cache");
		}
		//log.debug(htmlStr);
		
		PrintWriter out = response.getWriter();
		out.println(htmlStr);

		return null;
	}

	
	public static void clearCache() {
		htmlStr = null;
		log.info("cache cleared");
		new com.ulic.ulweb.ulweb.web.action.IndexAction().initList();
		//log.info("ulweb list init.");
		//log.debug(htmlStr);
	}
	
	public String getCache() {
		return htmlStr;
	}
	
}
