package com.rbu.emailservice.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.rbu.emailservice.model.Mail;

@Service
public class MailServiceImpl implements MailService
{
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(Mail mail) 
	{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setCc(mail.getMailCc());
			mimeMessageHelper.setBcc(mail.getMailBcc());
			mimeMessageHelper.setText(mail.getMailContent());
			mimeMessageHelper.addAttachment("mysql.cfg.xml",new File("C:\\Users\\Welcome\\Downloads\\Sending-Emails-using-Spring-Boot-Mail-master\\Sending-Emails-using-Spring-Boot-Mail-master\\src\\main\\resources\\mysql.cfg.xml"));
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
