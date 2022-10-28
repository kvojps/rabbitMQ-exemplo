package com.microservices.msemail.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.msemail.model.Email;
import com.microservices.msemail.model.dtos.EmailDTO;
import com.microservices.msemail.service.EmailService;

@RestController
public class EmailAPI {

	@Autowired
	private EmailService service;
	
	@PostMapping("/send-email")
	public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		
		Email emailSent = service.sendEmail(email);
		return new ResponseEntity<>(emailSent, HttpStatus.CREATED);
	}
}
