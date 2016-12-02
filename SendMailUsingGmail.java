package com.sunbeam.myapps;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUsingGmail {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("**your_username**","**your-password**");
				}
			});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("your_gmail_id_complete_email_id"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("to@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Rohit," +
					"\n\n TEST MAIL!");
			Transport.send(message);
			System.out.println("Mail Sent Successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
