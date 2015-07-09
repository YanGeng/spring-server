package com.amos.service;

import org.apache.commons.mail.HtmlEmail;

public class EmailService {
	private HtmlEmail email;
	private String charSet;
	private String hostName;
	private int smtpPort;
	private String useName;
	private String passWord;
	private String from;
	private String subject;
	private String htmlTemplate;
	private String to;
	private String SSLOnConnect;
	
	public EmailService() {
		email = new HtmlEmail();
	}

	public String getCharSet() {
		return charSet;
	}

	public void setCharSet(String charSet) {
		this.charSet = charSet;
		email.setCharset(charSet);
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
		email.setHostName(hostName);
	}

	public int getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(int smtpPort) {
		this.smtpPort = smtpPort;
		email.setSmtpPort(smtpPort);
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getHtmlTemplate() {
		return htmlTemplate;
	}

	public void setHtmlTemplate(String htmlTemplate) {
		this.htmlTemplate = htmlTemplate;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSSLOnConnect() {
		return SSLOnConnect;
	}

	public void setSSLOnConnect(String sSLOnConnect) {
		SSLOnConnect = sSLOnConnect;
	}
}
