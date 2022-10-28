package com.microservices.msemail.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.microservices.msemail.model.Email;
import com.microservices.msemail.model.dtos.EmailDTO;
import com.microservices.msemail.service.EmailService;

@Component
public class EmailConsumer {

	@Autowired
	EmailService emailService;
	
	@RabbitListener(queues = "${spring.rabbitmq.ms-email.queue}")
	public void listen(@Payload EmailDTO emailDTO) {
		Email email = new Email();
		BeanUtils.copyProperties(emailDTO, email);
		emailService.sendEmail(email);
		
		System.out.println("Email status: " + email.getStatusEmail().toString());
	}
}
