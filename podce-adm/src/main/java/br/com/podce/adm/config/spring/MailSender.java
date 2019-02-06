package br.com.podce.adm.config.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSender {

	@Autowired
	private JavaMailSender sender;

}
