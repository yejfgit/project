package com.survey.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.survey.service.IDeptService;
import com.survey.service.IMissionService;
import com.survey.service.ISurveyService;
import com.survey.service.IUserService;
import com.survey.util.ConfigManager;
import com.survey.util.ContextUtil;
import com.survey.util.ServiceLocator;
import com.survey.util.SmtpAuth;
import com.survey.util.StringUtil;
import com.survey.util.UlicSendMail;
import com.survey.vo.Mission;
import com.survey.vo.Survey;
import com.survey.vo.TUmUser;




public class MailAction extends BaseAction {
	
//	private String body = "现总公司运营中心有一份问卷需要您作答!<br>" + "'surveyName'"+
//			"请您及时点击登录 <a href=http://10.53.32.1:9080/survey/login.do target=_blank>问卷系统</a> 进行答题。谢谢！";
	private  String smtpServer = "10.18.8.41";
	private  String from = "oamail@ulic.com.cn";
	private  String fromName = "问卷系统";
	private  String user = "oamail";
	private  String password = "yy888888";
	
	private IMissionService ms = (IMissionService) ServiceLocator.getService("missionService");
	private IUserService userService = (IUserService) ServiceLocator.getService("userService");
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
		
		int userId = ContextUtil.getCurrentUserId();
		List surveyList = surveyService.getSurveyListByAdminUserId(userId);
		List surveyLabelList = new ArrayList();
		for (Iterator it = surveyList.iterator(); it.hasNext();) {
			Survey survey = (Survey) it.next();
			int ss = survey.getId();
			LabelValueBean typeOption = new LabelValueBean(survey.getName(),String.valueOf(survey.getId()));
			surveyLabelList.add(typeOption);
		}
		
		request.setAttribute("surveyLabelList", surveyLabelList);
		
		return mapping.findForward("outside");
	}
		
	
	
	
	/**
	 * 指定外部用户的姓名和邮箱，自动为其建立用户，并下发问卷
	 */
	public ActionForward sendMailOutside(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String userName = request.getParameter("userName");
		String mail = request.getParameter("mail");
		
		TUmUser u = userService.saveUmUser(userName, mail);
		
		int surveyId = StringUtil.parseInt(request.getParameter("surveyId"));
		int userId = StringUtil.parseInt(u.getUmUserId());
		int deptId = StringUtil.parseInt(u.getUmOrgan());
		
		Mission mn = ms.requestMission(userId, surveyId, deptId);
		int missionId = mn.getId();
		String surveyName = surveyService.getSurveyById(surveyId).getName();
		String to = mail;
		UlicSendMail sm = new UlicSendMail();
        String subject = "您的新问卷："+surveyName+"";
        
        String root = ConfigManager.getString("webURL");
		String url = root + request.getContextPath() + "/mission.do?method=jump" +
				"&userId=" + userId + 
				"&missionId=" + missionId;
		String tips = surveyService.getById(surveyId).getTips();
        if(tips==null) {
        	 tips = "";
        }	    		
	    String body = "<span> "+ tips + "" +
	    		"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
	    		"您好，请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";

        sm.send(to, from, subject, body);
		
		request.setAttribute("info", "外部用户问卷已下发成功");
		return mapping.findForward("info");
	}
	
	
	
	public ActionForward sendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		DynaActionForm af = (DynaActionForm)form;
		String umUsers = request.getParameter("msg");
		String[] users = request.getParameter("msg").split(";"); 
//		System.out.println(users.length);
//		System.out.println(umUsers.length());
		if(umUsers.length()!=0){
		for(int i = 0;i < users.length; i++){ 
				int userId = Integer.parseInt(users[i]);
				//System.out.println(userId);
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
				UlicSendMail sm = new UlicSendMail();
	            String subject = "您的新问卷："+surveyName+"";
	            
	            String root = ConfigManager.getString("webURL");
	    		String url = root + request.getContextPath() + "/mission.do?method=jump" +
	    				"&userId=" + userId + 
	    				"&missionId=" + missionId;
	    		String tips = surveyService.getById(surveyId).getTips();
	            if(tips==null){
	            	 tips = "";

	            }	    		
			    String body = "<span> "+ tips + "" +
			    		"<span>&nbsp;&nbsp;&nbsp;&nbsp;" +
			    		"您好，请点击：<a href=\"" + url + "\" target=_blank>开始答卷</a> ，及时完成答卷。谢谢！";

		        boolean forward = sm.send(to, from, subject, body);
		    	request.setAttribute("info", "问卷已下发成功");
                mn.setIsClosed(0);
//		        System.out.println(Integer.parseInt(userService.getUmUserByUserId(userId).getUmOrgan()));
		        request.setAttribute("missionId", mn.getId());
		        
		}
		return new ActionForward("mission.do?method=monitor", true);
		}else{
		request.setAttribute("info", "请选择用户");}
		return  mapping.findForward("info");
	}
}
//	public boolean send(String to, String from, String subject, String body) {
//	SmtpAuth sa = new SmtpAuth(user, password);	
//	Properties props = System.getProperties();
//	props.put("mail.smtp.host", smtpServer);
//	Session session = null;
//	if(user == null || user.length()==0){
//		props.put("mail.smtp.auth", "false");
//		session = Session.getDefaultInstance(props);
//	}else{
//		props.put("mail.smtp.auth", "true");
//		session = Session.getDefaultInstance(props, sa);
//	}
//
//	Message msg = new MimeMessage(session);
//	try {
//		BodyPart mdp = new MimeBodyPart();
//		//mdp.setContent(body, "text/html;charset=utf-8");
//		mdp.setContent(body, "text/html;charset=gb2312");
//		Multipart mm = new MimeMultipart();
//		mm.addBodyPart(mdp);
//		msg.setContent(mm);
//		msg.setFrom(new InternetAddress(from,fromName));	
//		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
//		msg.setSubject(subject);
//		msg.setHeader("X-Mailer", "LOTONtechEmail");
//		msg.setSentDate(new Date());
//		msg.saveChanges();
//		Transport.send(msg);
//		//System.out.println("send ok");
//		return true;
//	}
//	catch (Exception e) {
//		e.printStackTrace();
//		return false;
//	}
//}
//