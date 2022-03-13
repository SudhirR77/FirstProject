package com.cjc.ws.mailsender.main.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cjc.ws.mailsender.main.model.MailSender;

@Service
public class MailSenderService {
	@Autowired
	private JavaMailSender javaMailSender;

	public void SendEmail(MailSender ms) {
		
		SimpleMailMessage smm=new SimpleMailMessage();
		
		smm.setFrom(ms.getFromEmail());
		smm.setTo(ms.getToEmail());
		smm.setSubject(ms.getSubject());
		smm.setText(ms.getTextmsg());
		System.out.println(ms.getToEmail());
		System.out.println(ms.getSubject());
		
		System.out.println(ms.getTextmsg());
		javaMailSender.send(smm);
		
		System.out.println("Mail sent successfully");
		
	}


	public void SendEmailWithAttachment(MailSender ms) {
		
		MimeMessage message=javaMailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setFrom(ms.getFromEmail());
			helper.setTo(ms.getToEmail());
			helper.setSubject(ms.getSubject());
			helper.setText(ms.getTextmsg());
			
			FileSystemResource fsr=new FileSystemResource("C:\\Users\\Saroj Rai\\oops_concept.pdf");
			helper.addAttachment(fsr.getFilename(), fsr);
			javaMailSender.send(message);
			
			
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		
	}

}
