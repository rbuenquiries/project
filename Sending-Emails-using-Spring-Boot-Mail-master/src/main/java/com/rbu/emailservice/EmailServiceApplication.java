package com.rbu.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rbu.emailservice.service.MailService;

@SpringBootApplication
public class EmailServiceApplication 
{
	@Autowired
	private MailService mailService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception { Mail mail = new
	 * Mail(); mail.setMailFrom("busrbu@gmail.com");
	 * mail.setMailTo("mandava.naveenkumar@gmail.com");
	 * mail.setMailSubject("Spring Boot - Email demo");
	 * mail.setMailContent("Just testing"); mailService.sendEmail(mail); }
	 */

}
