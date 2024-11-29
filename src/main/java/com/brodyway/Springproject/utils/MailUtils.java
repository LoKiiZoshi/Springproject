package com.brodyway.Springproject.utils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;


@Component
public class MailUtils {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String toEmail, String subject, String message) { 
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toEmail);
		mail.setSubject(subject);
		mail.setText(message);
		
		javaMailSender.send(mail);
		
	}
//	  public void sendEmailWithAttachment(String toEmail, String subject, String message)   {
//
//        MimeMessage msg = JavaMailSender.createMimeMessage();
//
//        // true = multipart message
//        MimeMessageHelper helper;
//		try {
//			helper = new MimeMessageHelper(msg, true);
//		
//		
//        helper.setTo("toEmail");
//
//        helper.setSubject("subject");
//
//        // default = text/plain
//        //helper.setText("Check attachment for image!");
//
//        // true = text/html
//        helper.setText("<h1>Check attachment for image!</h1>", true);
//
//		// hard coded a file path
//        //FileSystemResource file = new FileSystemResource(new File("path/android.png"));
//
//        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//        JavaMailSender.send(msg);
//
//    }

}
