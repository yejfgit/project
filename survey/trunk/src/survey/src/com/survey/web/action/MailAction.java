package com.survey.web.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.ServiceLocator;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.vo.Mission;
import com.survey.vo.Survey;
import com.survey.vo.TUmUser;




public class MailAction extends BaseAction {
	
	
	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	private IUserService userService = (IUserService) ServiceLocator.getService("svUserService");
	private ISurveyService surveyService = (ISurveyService) ServiceLocator.getService("surveyService");
	
	
	public ActionForward test(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String root = ConfigManager.getString("webURL");
		String url = root + request.getContextPath() + "/mission.do?method=answer&surveyId=";
		System.out.println(url);
		return null;
	}
	
	
	
	public ActionForward toSendMailOutside(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		Survey survey = surveyService.getSurveyById(surveyId);
		
		request.setAttribute("survey", survey);
		return mapping.findForward("outside");
	}
		
	
	
	
	/**
	 * 指定外部用户的姓名和邮箱，自动为其建立用户，并下发问卷
	 */
	public ActionForward sendMailOutside(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userParam = request.getParameter("user");
		String[] users = userParam.split(";");
		for (int i = 0; i < users.length; i++) {
			String user = users[i];
			String[] nameAndMail = user.split(",");
			String userName = StringUtil.decodeStr(nameAndMail[0]);
			String mail = nameAndMail[1];

			TUmUser u = userService.saveUmUser(userName, mail);
			int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
			int userId = StringUtil.parseInt(u.getUmUserId());
			int deptId = StringUtil.parseInt(u.getUmOrgan());
			
			Mission mn = ms.requestMission(userId, surveyId, deptId);
			int missionId = mn.getId();
			String surveyName = surveyService.getSurveyById(surveyId).getName();
			String to = mail;
	        String subject = "您的新问卷："+surveyName+"";
	        
	        String root = ConfigManager.getString("webURL");
			String url = root + request.getContextPath() + "/mission.do?method=jump" +
					"&userId=" + userId + 
					"&missionId=" + missionId;    		
			
    		String mailTips = surveyService.getSurveyById(surveyId).getMailTips();
    		
    		if(mailTips==null){
    			mailTips = "";
    		}
			
			String body = mailTips +
			"<br><span>&nbsp;&nbsp;&nbsp;&nbsp;" +
    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";

		    UlicSendMail.sendMail(to, subject, body,"");
			
			
			
			
		}
		
//		return new ActionForward("mail.do?method=toSendMailOutside",true);	
		return mapping.findForward("dialogDone");
	}
	
	
	
	public ActionForward sendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		DynaActionForm af = (DynaActionForm)form;
		String umUsers = request.getParameter("msg");
		String[] users = request.getParameter("msg").split(";"); 
		String organ = request.getParameter("deptId");
//		System.out.println(users.length);
//		System.out.println(umUsers.length());
		if(umUsers.length()!=0){
		for(int i = 0;i < users.length; i++){ 
				int userId = Integer.parseInt(users[i]);
				String si = request.getParameter("name1");
				String surveyId1 = request.getParameter("name1");
				if(surveyId1 == null){
					request.setAttribute("info", "请您在下发前创建试卷");
					return  mapping.findForward("info");
				}
				int surveyId = Integer.parseInt(surveyId1);
				int deptId = Integer.parseInt(userService.getUmUserByUserId(userId).getUmOrgan());
				Mission mn = ms.requestMission(userId, surveyId,deptId);
				int missionId = mn.getId();
    			String surveyName = surveyService.getSurveyById(surveyId).getName();
				String to = userService.getUmUserByUserId(userId).getMail();
	            String subject = "您的新问卷："+surveyName+"";
	            
	            String root = ConfigManager.getString("webURL");
	    		String url = root + request.getContextPath() + "/mission.do?method=jump" +
	    				"&userId=" + userId + 
	    				"&missionId=" + missionId; 
	    		
	    		String mailTips = surveyService.getSurveyById(surveyId).getMailTips();
	    		
	    		if(mailTips==null){
	    			mailTips = "";
	    		}
	    		
			    String body =mailTips +
			    			"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
			    		"请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";

			    UlicSendMail.sendMail(to, subject, body,"");
			    

		    	request.setAttribute("info", "问卷已下发成功");
                mn.setIsClosed(0);
//		        System.out.println(Integer.parseInt(userService.getUmUserByUserId(userId).getUmOrgan()));
		        request.setAttribute("missionId", mn.getId());
		        
		}
		return new ActionForward("user.do?method=userList&deptId="+organ, true);
		}else{
		request.setAttribute("info", "请选择用户");}
		return  mapping.findForward("info");
	}
}
