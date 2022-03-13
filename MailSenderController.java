package com.cjc.ws.mailsender.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.ws.mailsender.main.model.MailSender;
import com.cjc.ws.mailsender.main.service.MailSenderService;

@RestController
public class MailSenderController {
	@Autowired
	MailSenderService mss;
	
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping(value = "/mailSender")
	public String EmailSender(@RequestBody MailSender ms)
	{
		ms.setFromEmail(fromEmail);
		System.out.println("fromMail"+fromEmail);	
		try {
			System.out.println(" try strt");
			mss.SendEmail(ms);
			return "Email is Sent";
		} catch (Exception e) {
			return "Email is not Sent";
		}	
	}
	
	@PostMapping(value = "/withAttactment")
	public String withAttachmentMailSender(@RequestBody MailSender ms)
	{
		ms.setFromEmail(fromEmail);
		
		mss.SendEmailWithAttachment(ms);
		
		
		
		return "email Sent Successfully";
	}

}
