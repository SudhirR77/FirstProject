package com.cjc.ws.mailsender.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailSender {
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textmsg;
}
