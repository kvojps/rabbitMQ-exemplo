package com.microservices.msemail.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${spring.rabbitmq.ms-email.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.ms-email.queue}")
	private String queue;
	
	@Value("spring.rabbitmq.ms-email.routingkey")
	private String routingKey;
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true);
	}
	
	@Bean
	public DirectExchange exchange() {
		return ExchangeBuilder.directExchange(exchange).durable(true).build();
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
}
