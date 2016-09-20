package com.ulic.ulweb.frame.servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

//import com.ulic.ulweb.ulweb.service.admin.IPostService;
//import com.ulic.ulweb.ulweb.util.ColumnCache;
//import com.ulic.ulweb.ulweb.util.DictUtil;


import org.apache.velocity.app.Velocity;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.constant.Constant;
import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.frame.util.PageTool;
import com.ulic.ulweb.ulweb.entity.UlReport;
import com.ulic.ulweb.ulweb.service.IUlReportService;
import com.ulic.ulweb.ulweb.util.ResourceUtil;
import com.ulic.ulweb.ulweb.web.action.IndexAction;
import com.ulic.ulweb.ulweb.web.action.admin.InitAction;
import com.ulic.ulweb.ulweb2.service.impl.task.ConverListerer2;
import com.ulic.ulweb.ulweb2.service.impl.task.SecureListerer;
import com.ulic.ulweb.ulweb2.util.ConfigManager;
import com.ulic.ulweb.ulweb2.util.UlicSendMail;


public class InitServlet extends HttpServlet {
	public void init() throws ServletException {
		this.intiService();
		this.initLog();
		this.initSendMail();
		this.initLdap();
		
		ConverListerer2 converListener = ConverListerer2.getInstance();
		converListener.start();
		
		SecureListerer secureListener = SecureListerer.getInstance();
		secureListener.start();
	}
	
	private void initSendMail() {
		String smtp = ConfigManager.getString("mail_server_ip");
		String user = ConfigManager.getString("mail_user_name");
		String pwd = ConfigManager.getString("mail_user_password");
		String from = ConfigManager.getString("mail_from");
		String fromName = ConfigManager.getString("mail_from_name");
		
		if (smtp != null) {
			UlicSendMail.SMTPSERVER = smtp;
		}
		if (user != null) {
			UlicSendMail.USER = user;
		}
		if (pwd != null) {
			UlicSendMail.PASSWORD = pwd;
		}
		if (from != null) {
			UlicSendMail.FROM = from;
		}
		if (fromName != null) {
			UlicSendMail.FROMNAME = fromName;
		}
		
		System.out.println("UlicSendMail.SMTPSERVER=" + UlicSendMail.SMTPSERVER);
		System.out.println("UlicSendMail.USER=" + UlicSendMail.USER);
		System.out.println("UlicSendMail.PASSWORD=" + UlicSendMail.PASSWORD);
		System.out.println("UlicSendMail.FROM=" + UlicSendMail.FROM);
		System.out.println("UlicSendMail.FROMNAME=" + UlicSendMail.FROMNAME);
		
		
	}
	
	private void initLdap() {
		System.out.println("ldap.server.url=" + ConfigManager.getString("ldap.server.url"));
		System.out.println("ldap.userdn=" + ConfigManager.getString("ldap.userdn", ".", ","));
		System.out.println("ldap.userdn.pwd=" + ConfigManager.getString("ldap.userdn.pwd"));
		System.out.println("ldap.basedn=" + ConfigManager.getString("ldap.basedn", ".", ","));
		System.out.println("ldap.search.prefix=" + ConfigManager.getString("ldap.search.prefix", ".", ","));
		System.out.println("ldap.search.suffix=" + ConfigManager.getString("ldap.search.suffix", ".", ","));
		
		
	}
	
	private void intiService() {
		ServiceLocator.ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this
				.getServletContext());
		String realPath = this.getServletConfig().getServletContext().getRealPath("/");
		PageTool.imgPath = this.getServletConfig().getInitParameter("pageImg");
		System.out.println(PageTool.imgPath);
		Constant.realPath = realPath;
		System.out.println(realPath);
		Constant.SAVEPATH = realPath + "files/";
		Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, getServletContext()
				.getRealPath("/vm/"));
		Velocity.setProperty(Velocity.COUNTER_NAME, "velocityCount");
		Velocity.setProperty(Velocity.COUNTER_INITIAL_VALUE, "0");
		Velocity.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
		Velocity.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		Velocity.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		
//初始化一此数据
		InitAction ia = new InitAction();
		ia.initAll();
		
//给数组赋值
		
		boolean isSuccessful = true;
/*		try {
			List list = ((IPostService)ServiceLocator.getServiceProxy("postService")).getList();
			this.getServletContext().setAttribute("gPostList",list);
			//ServiceLocator.ctx..setAttribute("gPostList",list);
			
		} catch (Exception e) {
			System.out.println("\n inti fail =================== \n");
			e.printStackTrace();
			isSuccessful = false;
		}
		try {
			DictUtil.init();
			ColumnCache.loadColumnCache(0);
			Velocity.init();
			SendMail.init();
		}
		catch (Exception e) {
			System.out.println("\n inti fail =================== \n");
			e.printStackTrace();
			isSuccessful = false;
		}
*/
		Constant.contextPath = this.getServletContext().getContextPath();
		
		
		if(isSuccessful) {
			System.out.println("\n inti ok =================== " + Constant.contextPath + "\n");
		}
		if (!ResourceUtil.initUlwebProperties()) {
//			System.err.println("\n ulweb.properties not found! \n");
		} else {
//			System.err.println("\n ulweb.properties success!");
//			System.err.println("upload: " + ResourceUtil.getFilesRootDir());
//			System.err.println("download: " + ResourceUtil.getFilesPathDir());
		}
		
	}
	private void initLog() {
		// BasicConfigurator.configure();
	}
	
	
}
