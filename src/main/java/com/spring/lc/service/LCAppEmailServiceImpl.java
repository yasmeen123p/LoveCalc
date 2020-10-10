package com.spring.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	private JavaMailSenderImpl JavaMailSenderImpl;

	@Override
	public void sendEmail(String userName, String userEmail, String result) {
		SimpleMailMessage newEmail = new SimpleMailMessage();
		newEmail.setTo(userEmail);
		newEmail.setSubject("Love Calculator Application result");
		newEmail.setText("Hi " + userName + "The result predicted by the Love Calculator App is" + result);

		JavaMailSenderImpl.send(newEmail);
	}

}
