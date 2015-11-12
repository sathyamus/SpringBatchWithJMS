package com.snsystems.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
	
	private Logger LOG = LoggerFactory.getLogger(MailService.class);
	
	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage preConfiguredMessage;

	/**
	 * This method will send compose and send the message
	 * */
	public void sendMail(String from, String to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(body);
		LOG.info("Sending mail");
		// mailSender.send(message);
	}

	/**
	 * This method will send a pre-configured message
	 * */
	public void sendPreConfiguredMail(String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage(
				preConfiguredMessage);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
}