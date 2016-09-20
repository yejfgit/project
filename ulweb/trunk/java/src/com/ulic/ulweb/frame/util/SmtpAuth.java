package com.ulic.ulweb.frame.util;


import javax.mail.PasswordAuthentication;

public class SmtpAuth extends javax.mail.Authenticator {
	private String userID = null;
	private String password = null;
	public SmtpAuth() {
	}
	public SmtpAuth(String userID, String password) {
		this.setUserID(userID);
		this.setPassword(password);
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserID() {
		return userID;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(userID, password);
	}
}