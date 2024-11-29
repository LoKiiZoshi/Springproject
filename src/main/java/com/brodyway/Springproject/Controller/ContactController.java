package com.brodyway.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brodyway.Springproject.utils.MailUtils;

@Controller
public class ContactController {
	@Autowired
	private MailUtils mailUtil;
	
	@GetMapping("/contact")
	public String getContact() {
		
		return "ContactForm";
	}
	
	
	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		mailUtil.sendEmail(toEmail,subject,message);
   //		mailUtil.sendEmailWithAttachment(toEmail, subject, message);
		
		return "ContactForm";
	}

}
