package com.amos.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Test {

	public static void main(String[] args) throws EmailException, IOException {
		String htmlTemplate = "<h3><center>2015-04-01商户通产品日报</center></h3><p><b>1. 概况</b></p><table style=\"width:95%;padding:1px;border-collapse:collapse;\" border=\"1\"><tr bgcolor=\"#E3F5FF\"><th>指标</th><th>当日</th><th>日环比</th><th>周同比</th></  tr>";
		HtmlEmail email = new HtmlEmail();
		email.setCharset("UTF-8");
		email.setDebug(true);
		email.setHostName("mail.51ping.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("ad-data@dianping.com",
				"midas4DPMDS"));
		email.setSSLOnConnect(false);
		email.setFrom("ad-data@dianping.com");
		email.setSubject("Test email");
		//email.setMsg("This is a test email ...");
		email.setHtmlMsg(htmlTemplate);
		email.addTo("tony.geng@dianping.com"); // 耿严 <tony.geng@dianping.com>
		email.send();
//		Process process = Runtime.getRuntime().exec("top");
//		InputStream in= process.getErrorStream();
//		byte[] bytes = new byte[1024];
//		int length = -1;
//		while((length = in.read(bytes)) != -1) {
//			System.out.println(new String(bytes, 0, length));
//		}
//		in.close();
	}
}
