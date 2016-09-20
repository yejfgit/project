package com.survey.web.servlet;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.survey.service.IMissionService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.ResourceUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.UlicSendMail;
import com.survey.vo.Mission;
import com.survey.web.action.MailAction;


/**
 * 启动 applicationContext 环境
 * 
 * @author
 * 
 */

public class InitServlet extends HttpServlet {
	
	private String body = "请您及时进行答卷";
	private String body1 = "您此次问卷已关闭";
	private  String from = "oamail@ulic.com.cn";
	private String subject = "欢迎使用问卷系统";
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		this.intiService();
		this.initLog();
		
	}

	private void intiService() {
		ServiceLocator.ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());

		ResourceUtil.getInstance();
		
		this.startHurryTimer();
	}

	private void initLog() {
		// BasicConfigurator.configure();
	}
	
	private void startHurryTimer() {
		final String root = ConfigManager.getString("webURL") + 
			this.getServletContext().getContextPath();
		System.out.println("root:" + root);

		Date firstTime = new Date();
	    firstTime.setDate(firstTime.getDate() + 1);
		firstTime.setHours(0);
		firstTime.setMinutes(0);
		firstTime.setSeconds(0);
		System.out.println(firstTime.toLocaleString());
		
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				Date now = new Date();
				IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
				IUserService userService = (IUserService) ServiceLocator.getService("userService");
				List ubmList = ms.getUnBeginMission();
				for (int i = 0; i < ubmList.size(); i++) {
					Mission m = (Mission) ubmList.get(i);
					Date reqTime = (Date) m.getRequestTime().clone();
					reqTime.setDate(reqTime.getDate() + 1);
					if (now.after(reqTime) && m.getHurryTimes() < 3) {
						UlicSendMail ma = new UlicSendMail();
						String to = userService.getUmUserByUserId(m.getUserId()).getMail();
						
						String url = root + "/mission.do?method=jump" +
						"&userId=" + m.getUserId() + 
						"&missionId=" + m.getId();
						String body = "您好，请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";
						ma.send(to, from, subject, body);
						m.setHurryTimes(m.getHurryTimes() + 1);
						ms.updateMission(m);
						}else if(m.getHurryTimes()== 3){
							UlicSendMail ma = new UlicSendMail();
							String to = userService.getUmUserByUserId(m.getUserId()).getMail();
							ma.send(to, from, subject, body1);
							m.setIsClosed(3);
							ms.updateMission(m);
						}

					}
				}
					
		}, firstTime, 86400*1000);
		
		
	}

}
