package com.microservices.msemail.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.msemail.model.Email;
import com.microservices.msemail.model.enums.StatusEmail;
import com.microservices.msemail.repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;
	
	public Email sendEmail(Email email) {
		LocalDateTime emailDateTime = LocalDateTime.now();
		
		email.setStatusEmail(StatusEmail.SENT);
		email.setSendDateEmail(emailDateTime);
		
		return repository.save(email);
	}
}
