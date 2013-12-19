package com.webappspringmvc;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
	
	public static void sendMail(String email,String name){
		Properties pro = new Properties();
		Session session_new = Session.getDefaultInstance(pro, null);
		try{
			Message msg = new MimeMessage(session_new);
			msg.setFrom(new InternetAddress("vb2adapt@gmail.com","gmail.com vb2adapt"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email,"Mr."+name));
			msg.setSubject("Welcome mail form sample application");
			msg.setText("Welcome mail from http://mvcsampledemo.appspot.com ");
			Transport.send(msg);
		}
		catch(Exception e){
			System.err.println(e.getStackTrace());
		}
	}

}
