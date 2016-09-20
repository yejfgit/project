package com.survey.web.servlet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.DataSourceUtil;
import com.survey.util.ResourceUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.UlicSendMail;
import com.survey.vo.Mission;
import com.survey.vo.Survey;


/**
 * 启动 applicationContext 环境
 * 
 * @author
 * 
 */

public class InitServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		this.intiService();
		this.initLog();
		
	}

	private void intiService() {
		ServiceLocator.ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());

		ResourceUtil.getInstance();
		
		UlicSendMail.startMailQueue();
		
//		this.syncUser();
//		this.startHurryTimer();
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
				IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
				ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
				List ufmList = ms.getUnFinishedMission();
				for (int i = 0; i < ufmList.size(); i++) {
					Mission m = (Mission) ufmList.get(i);
					Survey s = surveyService.getById(m.getSurveyId());
					Date reqTime = (Date) m.getRequestTime().clone();
					reqTime.setDate(reqTime.getDate() + 1);
					if (now.after(reqTime) && m.getHurryTimes() < 3) {
						String to = userService.getUmUserByUserId(m.getUserId()).getMail();
						
						String url = root + "/mission.do?method=jump" +
						"&userId=" + m.getUserId() + 
						"&missionId=" + m.getId();
						String body = "您好，感谢您的热情参与！请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";
						UlicSendMail.sendMail(to, "问卷提醒：" + s.getName(), body,"");
						m.setHurryTimes(m.getHurryTimes() + 1);
						ms.updateMission(m);
						}else if(m.getHurryTimes()== 3){
							String to = userService.getUmUserByUserId(m.getUserId()).getMail();
							UlicSendMail.sendMail(to, "问卷关闭：" + s.getName(), "您的此次问卷已关闭","");
							m.setIsClosed(3);
							ms.updateMission(m);
						}

					}
				}
					
		}, firstTime, 86400*1000);
		
		
	}
	
	private void syncUser(){
		Timer t = new Timer();
		t.schedule(new TimerTask() {
		static final String mutex = "";
			@Override
			public void run() {
				synchronized(mutex){
					System.out.println("--------------------------sycn begin"+ System.currentTimeMillis());
					
					String procStr = "SV_p_syncHrUserData.p_syncHrUserData";
					String[] procPara = null;
//					String dateStr = DateUtil.getSysDateStr();
//					procPara = dateStr.split("-");
//					System.out.println(procPara[0] + procPara[1] + procPara[2]);
//					procPara[2] = procPara[1];
//					procPara[1] = "1";
					callProcedure(procStr, procPara);
					
					
					System.out.println("--------------------------sycn end"+ System.currentTimeMillis());
				}
				}
					
		}, new Date(), 3*60*1000);
	}
	
	public void callProcedure(final String procStr, final Object[] procPara){
		String sql = "{call " + procStr + "}";
		try
		{
			Connection conn = DataSourceUtil.getConnection();
			CallableStatement cs = conn.prepareCall(sql);
			if( procPara != null )
			{
				for(int i=1; i<=procPara.length; i++)
				{
					cs.setString(i, (String)procPara[i-1]);
				}
			}
			cs.executeUpdate();
//	 	cs.execute();
//		 cs.executeQuery();
			cs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
