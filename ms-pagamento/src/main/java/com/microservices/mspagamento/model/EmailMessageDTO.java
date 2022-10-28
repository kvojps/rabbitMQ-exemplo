package com.microservices.mspagamento.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

import lombok.Data;

@Component
@Data
public class EmailMessageDTO implements Serializable {
	
	@NotBlank
	private String ownerRef;
	
	@NotBlank
	@Email
	private String emailFrom;
	
	@NotBlank
	@Email
	private String emailTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;
}
