package com.ulic.ulweb.ulweb2.util;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ulic.ulweb.frame.service.ServiceLocator;
import com.ulic.ulweb.frame.util.SmtpAuth;
import com.ulic.ulweb.ulweb2.dao.IMailDao;
import com.ulic.ulweb.ulweb2.entity.MailEntity;


public class UlicSendMail extends Thread{

	Log log = LogFactory.getLog(getClass());
	
	public static String USER = "ulwebtest";
	public static String PASSWORD = "Policy#pdfg";
	public static String SMTPSERVER = "10.18.8.20";
	public static String FROM = "ulwebtest@ulic.com.cn";
	public static String FROMNAME = "合众人寿内部网系统邮件";
	
	private Message msg ;
	private String to;
	private String subject;
	private String body;
	private String cc;
	private String bcc;

	private MailEntity mail = null;
	
	private IMailDao dao = (IMailDao)ServiceLocator.getService("mailDao");;

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
		
	
	/**
	 * 100316 yangyong 增加此方法用于发送之前没有发送成功的邮件，收件人邮箱需要输入。
	 */
	public boolean send(String to, MailEntity theMail){
		this.to = to;
		this.cc = theMail.getMailCc();
		this.bcc = theMail.getMailBcc();
		this.subject = theMail.getMailSubject();
		this.body = theMail.getMailBodyString();
		this.mail = theMail;
		mail.setSendTime(new Date(System.currentTimeMillis()));
		this.start();
		return true;
	}
		
	public boolean send(String to, String cc, String bcc, String subject, String body ) {
		this.to = to;		
		this.cc = cc;
		this.bcc = bcc;
		this.subject = subject;
		this.body = body;	
		
		mail = new MailEntity();
		mail.setMailTo(to);
		mail.setMailBcc(bcc);
		mail.setMailCc(cc);
		mail.setMailFrom(FROM);
		mail.setMailSubject(subject);
		mail.setMailBodyString(body);
		mail.setSendTime(new Date(System.currentTimeMillis()));		
		mail.setIsSuccess(0);
		
		this.start();
		return true;
	}	
	
	public void run() {		
		if(this.sendThisMail()){
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
		
	}
	
	private void sendMail(){
		try {		

			BodyPart mdp = new MimeBodyPart();
	//		mdp.setContent(body, "text/html;charset=utf-8");
			mdp.setContent(body, "text/html;charset=gb2312");
			Multipart mm = new MimeMultipart();
			mm.addBodyPart(mdp);			
			msg.setContent(mm);
			msg.setFrom(new InternetAddress(FROM,FROMNAME));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));
			msg.setSubject(subject);
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());
			msg.saveChanges();		
			Transport.send(msg);
			//System.out.println("send ok");
			mail.setIsSuccess(1);			
			UlicSendMail.changeNumberSendMailNow(0);
			dao.save(mail);
		}
		catch (Exception e) {
			if(this.tryTimesNow >= this.tryTimes){
				mail.setIsSuccess(0);
				UlicSendMail.changeNumberSendMailNow(0);

				dao.save(mail);
			}else{
				log.info("send mail false, times:" + this.tryTimesNow + ", try again!");
				this.tryTimesNow++;
				this.sendMail();
			}
			e.printStackTrace();
			//log.info(e.getMessage());
			
		}
	}
	
	public MailEntity getMail() {
		return mail;
	}
	public void setMail(MailEntity mail) {
		this.mail = mail;
	}
	
	private boolean sendThisMail(){
		if(UlicSendMail.numberSendMailNow < this.sendMailOnce){
			log.info("+++++++++++++send this mail" );
			return true;
		}else{
			try {
				log.info("+++++++++++++ this mail waiting,all waitings :" + UlicSendMail.numberSendMailNow );
				Thread.sleep(10000);					
			} catch (Exception e) {
				mail.setIsSuccess(0);
				dao.save(mail);	
				return false;
			}
			return this.sendThisMail();
		}
	}
}
