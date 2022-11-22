package com.rbu.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.emailservice.model.Mail;
import com.rbu.emailservice.service.MailServiceImpl;

@RestController
public class EmailRestController {
	@Autowired
	MailServiceImpl mailServiceImpl;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Mail mail) {
		mailServiceImpl.sendEmail(mail);
		return "success";
	}

}
