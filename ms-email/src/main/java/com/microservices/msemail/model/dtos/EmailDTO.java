package com.microservices.msemail.model.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDTO implements Serializable{
	
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
