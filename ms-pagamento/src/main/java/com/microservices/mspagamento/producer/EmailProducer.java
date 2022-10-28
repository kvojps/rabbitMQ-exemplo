package com.microservices.mspagamento.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.microservices.mspagamento.model.EmailMessageDTO;

@Service
public class EmailProducer {
	@Value("${spring.rabbitmq.ms-email.exchange}")
	private String exchange;
	
	@Value("spring.rabbitmq.ms-email.routingkey")
	private String routingKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(@Payload EmailMessageDTO email) {
		rabbitTemplate.convertAndSend(exchange, routingKey ,email);
	}
}
