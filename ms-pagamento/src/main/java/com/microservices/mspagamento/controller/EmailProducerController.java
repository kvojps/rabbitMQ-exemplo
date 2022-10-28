package com.microservices.mspagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.mspagamento.model.EmailMessageDTO;
import com.microservices.mspagamento.producer.EmailProducer;

@RestController
public class EmailProducerController {
	
	@Autowired
	private EmailProducer producer;
	
	@PostMapping("/publish/email")
	public String publishEmailMessage(@RequestBody EmailMessageDTO email) {
		producer.send(email);
		return "Mensagem enviada";
	}
}
