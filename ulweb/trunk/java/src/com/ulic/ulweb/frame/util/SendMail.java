package com.ulic.ulweb.frame.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import javax.mail.internet.MimeUtility;

public class SendMail {
	public static String USER = null;
	public static String PASSWORD = null;
	public static String SMTPSERVER = null;
	public static String FROM = null;
	public static String FROMNAME = null;
	/*
	public static void init() throws IOException {
		try{		 
		InputStream in = SendMail.class.getResourceAsStream("/config/config.properties");//ClassLoader.getSystemResourceAsStream("WEB-INF/classes/config/config.properties"); 
		Properties p = new Properties();
		p.load(in);	
	
		SendMail.USER = p.getProperty("emailuser");
		SendMail.PASSWORD = p.getProperty("emailpassword");
		SendMail.SMTPSERVER = p.getProperty("emailserver");
		SendMail.FROM = p.getProperty("from");
		
//		Ϊ����ȷ�s�����
		InputStream is = SendMail.class.getResourceAsStream("/config/config.properties");//ClassLoader.getSystemResourceAsStream("WEB-INF/classes/config/config.properties"); 
		InputStreamReader din = new InputStreamReader(is, "UTF-8");
		char[] myData = new char[100];
		din.read(myData, 0, myData.length);   
		String content = new String(myData); 
		String fromname = content.substring(content.lastIndexOf("=") + 1,content.length());

		SendMail.FROMNAME = fromname; 

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int sendAll(String[] to, String from, String subject, String[] body) throws Exception {
		int num = 0;
		String smtpServer = SendMail.SMTPSERVER;
		SmtpAuth sa = new SmtpAuth(SendMail.USER, SendMail.PASSWORD);
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", smtpServer);
		Session session = Session.getDefaultInstance(props, sa);
		try {
			for (int i = 0; i < to.length; i++) {
				if (to[i] != null && !to[i].equals("")) {
					Message msg = new MimeMessage(session);
					msg.setText(body[i]);
					msg.setFrom(new InternetAddress(from,SendMail.FROMNAME));
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
		return send(to,SendMail.FROM,subject,boday);
	}
	public boolean send(String to, String from, String subject, String body) {
		SmtpAuth sa = new SmtpAuth(SendMail.USER, SendMail.PASSWORD);
		String smtpServer = SendMail.SMTPSERVER;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		Session session = null;
		if(SendMail.USER == null || SendMail.USER.length()==0){
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
			msg.setFrom(new InternetAddress(from,SendMail.FROMNAME));
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

	public static void main(String[] args) {
		String to = "ak478288@163.com";
		String from2 = "ak478288@163.com";
		String subject = "qq";
		String html = "<html>" + "\n";
		String head = "<head><title>hello</title></head>" + "\n";
		String body = "<body>" + "\n";
		String content = "<h1>???!!!!!!!!!!!!</h1>";
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