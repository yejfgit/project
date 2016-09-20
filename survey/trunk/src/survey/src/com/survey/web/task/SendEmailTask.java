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
import com.survey.vo.TSendEmail;
import com.survey.vo.TUmOrgan;
import com.survey.vo.TUmUser;

public class SendEmailTask implements Runnable {
	
	public SendEmailTask(String[] args){
		System.out.println("========================hurryBegin====================");
	}
	
	public void run() {
		
		
		
		// TODO Auto-generated method stub
		Date now = new Date();
		IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
		ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
		IDeptService deptService = (IDeptService) ServiceLocator.getService("deptService");
		
		String root = ConfigManager.getString("webURL");
		System.out.println("root:" + root);
		
		List list = surveyService.getSendEmailList();
		
		
		for (int i = 0; i < list.size(); i++) {
			
			TSendEmail sendEmail= (TSendEmail)list.get(i);
			Survey survey = surveyService.getSurveyById(sendEmail.getSurveyId());
			TUmUser fqUser = userService.getUmUserByUserId(survey.getOwnerId());
			TUmOrgan fqOrgan = deptService.getUmOrganById(Integer.parseInt(fqUser.getUmOrgan()));
			
			String to = sendEmail.getEmail();

            String subject = "您的新问卷："+survey.getName()+"";

            String url = root + "/survey/mission.do?method=jump" +
    				"&userId=" +sendEmail.getUserId()+ 
    				"&missionId=" + sendEmail.getMissionId(); 
    		
    		String mailTips = survey.getMailTips();
    		
    		if(mailTips==null){
    			mailTips = "";
    		}
    		
		    String body =mailTips +
		    			"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
		    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！<br><br></span>"+
		    		"<div>&nbsp;&nbsp;&nbsp;&nbsp;" +
		    		"问卷发起人："+fqUser.getRealName()+"("+fqOrgan.getFullName()+")</div>";
		    
		    if(sendEmail.getIfCopySend()==1){
		    	TUmUser sendUser = userService.getUmUserByUserId(sendEmail.getUserId());
		    	subject=sendUser.getRealName()+",您好！您的新问卷："+survey.getName()+"";
		    	UlicSendMail.sendMail(to, subject, body,sendEmail.getCopySendEmail());
		    }else{
		    	UlicSendMail.sendMail(to, subject, body,"");
		    }
		    sendEmail.setIfSend(1);
		    sendEmail.setLcd(new Date());
		    surveyService.updateEntity(sendEmail);
		}
		
		
		System.out.println("========================End====================");
	}
}
