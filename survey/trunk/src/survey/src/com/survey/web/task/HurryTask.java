package com.survey.web.task;

import java.util.Date;
import java.util.List;

import com.survey.service.IDeptService;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.vo.DispatchUser;
import com.survey.vo.Mission;
import com.survey.vo.Survey;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;

public class HurryTask implements Runnable {
	
	public HurryTask(String[] args){
		System.out.println("========================hurryBegin====================");
	}
	
	public void run() {
		// TODO Auto-generated method stub
		Date now = new Date();
		IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
		IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
		ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
		IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
		
		String root = ConfigManager.getString("webURL");
		System.out.println("root:" + root);
		
		List ufmList = ms.getUnFinishedMission();
		
		
		for (int i = 0; i < ufmList.size(); i++) {
			Mission m = (Mission) ufmList.get(i);
			Survey s = surveyService.getSurveyById(m.getSurveyId());
			
			//发起人信息
			TUmUser fqUser = userService.getUmUserByUserId(s.getOwnerId());
			TUmOrgan fqOrgan = deptService.getUmOrganById(StringUtil.parseInt(fqUser.getUmOrgan()));
			
			Date reqTime = (Date) m.getRequestTime().clone();
			reqTime.setDate(reqTime.getDate() + 1);
			if (now.after(reqTime) && m.getHurryTimes() < s.getHurryTimes()) {
				m.setHurryTimes(m.getHurryTimes() + 1);
				ms.updateMission(m);
				
				DispatchUser user = userService.getDispatchUserByUmUserId(m.getUserId());
				
				String to = user.getWorkEmail();
				
				String url = root + "/survey/mission.do?method=jump" +
				"&userId=" + m.getUserId() + 
				"&missionId=" + m.getId();
				
				String hurryTips = s.getHurryTips();
				
	    		if(hurryTips==null){
	    			hurryTips = "<span>&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用合众人寿在线问卷系统，现在有一份问卷需要您填写。</span>";
	    		}
				
				String body =  hurryTips +
    			"<br><span>&nbsp;&nbsp;&nbsp;&nbsp;" +
	    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！<br><br></span>"+
	    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
	    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";
				
				UlicSendMail.sendMail(to, "问卷提醒：" + s.getName(), body,"");

			}else if(m.getHurryTimes()>= s.getHurryTimes()){
					DispatchUser user = userService.getDispatchUserByUmUserId(m.getUserId());
					
					String to = user.getWorkEmail();
					
					String closeTips = s.getCloseTips();
					
		    		if(closeTips==null){
		    			closeTips = "<span>&nbsp;&nbsp;&nbsp;&nbsp;由于您长时间未答，此次问卷已关闭。</span>";
		    		}
					
					String body = closeTips+"<br><br>"+
		    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
		    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";;
					
					UlicSendMail.sendMail(to, "问卷关闭：" + s.getName(), body,"");
					m.setIsClosed(3);
					ms.updateMission(m);
				}

			}
		System.out.println("========================hurryEnd====================");
	}
}
