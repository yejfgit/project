package com.ulic.ulweb.ulweb.web.action;


import java.util.Date;
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

import com.ulic.ulweb.frame.action.BaseAction;
import com.ulic.ulweb.frame.util.SmtpAuth;

public class SendmailAction extends BaseAction{

	private  String user = "";
	private  String password = "";
	private  String smtpServer = "10.18.8.20";
	private  String from = "oamail@ulic.com.cn";
	private  String fromName = "oamail";

	public ActionForward sendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String to = this.getStringValue(request, "to", "yangyong") + "@ulic.com.cn";
		String subject = this.getStringValue(request, "title");
		String body = this.getStringValue(request, "body");
		boolean forward = this.send(to, from, subject, body);		
		request.setAttribute("message", forward ? "发送成功" : "发送不成功");
		ActionForward af = new ActionForward();			
		af.setName("att");
		af.setPath("/admin/config/sendmail.jsp");
		return af;
	}
	
	
	public ActionForward juestSendMail(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String to = "yangyong@ulic.com.cn";
		String subject = this.getStringValue(request, "title");
		String body = this.getStringValue(request, "body");
		boolean forward = this.send(to, from, subject, body);		
		return null;
	}
	
	public int sendAll(String[] to, String from, String subject, String[] body) throws Exception {
		int num = 0;		
//		Authenticator sa = new Authenticator();
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", smtpServer);
//		Session session = Session.getDefaultInstance(props, sa);
		Session session = Session.getDefaultInstance(props);
		try {
			for (int i = 0; i < to.length; i++) {
				if (to[i] != null && !to[i].equals("")) {
					Message msg = new MimeMessage(session);
					msg.setText(body[i]);
					msg.setFrom(new InternetAddress(from,fromName));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[i], false));
					msg.setSubject(subject);
					msg.setHeader("X-Mailer", "LOTONtechEmail");
					msg.setSentDate(new Date());

					msg.saveChanges();
					Transport.send(msg);
					num++;
				}
			}
		}
		catch (Exception e) {
			throw new Exception("SendMail=========sendAll has error");
		}
		return num;
	}
	public boolean send(String to,String subject,String boday){
		return send(to,from,subject,boday);
	}
	public boolean send(String to, String from, String subject, String body) {
		SmtpAuth sa = new SmtpAuth(user, password);	
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		Session session = null;
		if(user == null || user.length()==0){
			props.put("mail.smtp.auth", "false");
			session = Session.getDefaultInstance(props);
		}else{
			props.put("mail.smtp.auth", "true");
			session = Session.getDefaultInstance(props, sa);
		}


		Message msg = new MimeMessage(session);
		try {
			BodyPart mdp = new MimeBodyPart();
			//mdp.setContent(body, "text/html;charset=utf-8");
			mdp.setContent(body, "text/html;charset=gb2312");
			Multipart mm = new MimeMultipart();
			mm.addBodyPart(mdp);
			msg.setContent(mm);
			msg.setFrom(new InternetAddress(from,fromName));	
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(subject);
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			msg.saveChanges();
			Transport.send(msg);
			//System.out.println("send ok");
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/*
	public static void main(String[] args) {
		String to = "ak478288@163.com";
		String from2 = "ak478288@163.com";
		String subject = "qq";
		String html = "<html>" + "\n";
		String head = "<head><title>hello</title></head>" + "\n";
		String body = "<body>" + "\n";
		String content = "<h1>���!!!!!!!!!!!!</h1>";
		String endbody = "</body></html>";
		String bodyy = html + head + body + content + endbody;
		try {
			SendMail.init();
			new SendMail().send(to, from2, subject, bodyy);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}*/
}
