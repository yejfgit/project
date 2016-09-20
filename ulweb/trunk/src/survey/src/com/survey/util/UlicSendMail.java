package com.survey.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class UlicSendMail extends Thread{

	public static String USER = "oamail";
	public static String PASSWORD = "yy888888";
	public static String SMTPSERVER = "10.18.8.41";
	public static String FROM = "oamail@ulic.com.cn";
	public static String FROMNAME = "问卷系统";
	
	private Message msg ;
	private String to;
	private String subject="欢迎使用问卷系统！";
	private String body;


//tryTimes为尝试发送次数，sendMailOnce为同时可以有多少个线程在等待发送，numberSendMailNow为现在有多少个正在等待发送	
	private int tryTimes = 2;
	private int tryTimesNow = 0;
	private int sendMailOnce = 30;
	private  static  int numberSendMailNow = 0; 
	
	/**
	 * 将正在发送的邮件个数清零，如果出现溢出，则调用这个方法清零
	 *
	 */
	public static void setNumberSendMailNowToZero(){
		UlicSendMail.numberSendMailNow = 0;
	}
	
	public static int getNumberSendMailNow(){
		return UlicSendMail.numberSendMailNow;
	}
	
	private static synchronized boolean changeNumberSendMailNow(int add){
		if(add == 1){
			numberSendMailNow++;	
			return true;
		}else if(add == 0){
			numberSendMailNow--;
			return true;
		}
		return false;
	}
	
	
	
	
/*	
	public int sendAll(String[] to, String from, String subject, String[] body) throws Exception {
		int num = 0;
		
		SmtpAuth sa = new SmtpAuth(USER, PASSWORD);
		Properties props = System.getProperties();		   
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.host", this.SMTPSERVER);
		Session session = Session.getDefaultInstance(props, sa);
		try {
			for (int i = 0; i < to.length; i++) {
				if (to[i] != null && !to[i].equals("")) {
					Message msg = new MimeMessage(session);
					msg.setText(body[i]);
					msg.setFrom(new InternetAddress(from,FROMNAME));
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to[i], false));
					msg.setSubject(subject);
					msg.setHeader("X-Mailer", "LOTONtechEmail");
					msg.setSentDate(new Date());

					msg.saveChanges();
//					Transport.send(msg);
					num++;
				}
			}
		}
		catch (Exception e) {			
			throw new Exception("SendMail=========sendAll has error");
		}
		return num;
	}
*/	


	public boolean send(String to, String from, String subject, String body) {
		this.to = to;		
		this.subject = subject;
		this.body = body;	
		
		this.start();
		return true;
	}	
	
	public void run() {		
			UlicSendMail.changeNumberSendMailNow(1);
			SmtpAuth sa = new SmtpAuth(USER, PASSWORD);
			String smtpServer = SMTPSERVER;
			Properties props = System.getProperties();
			props.put("mail.smtp.host", smtpServer);
			Session session = null;
			if(USER == null || USER.length()==0){
				props.put("mail.smtp.auth", "false");
				session = Session.getDefaultInstance(props);
			}else{
				props.put("mail.smtp.auth", "true");
				session = Session.getDefaultInstance(props, sa);
			}
	
			
			msg = new MimeMessage(session);
			this.sendMail();
		
	}
	
	private void sendMail(){
		
		try {
			BodyPart mdp = new MimeBodyPart();
//		mdp.setContent(body, "text/html;charset=utf-8");
			mdp.setContent(body, "text/html;charset=gbk");
			Multipart mm = new MimeMultipart();
			mm.addBodyPart(mdp);
			msg.setContent(mm);
			msg.setFrom(new InternetAddress(FROM,FROMNAME));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(subject);
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			msg.saveChanges();		
			Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("send ok");

	
	}

}
	
	
	

