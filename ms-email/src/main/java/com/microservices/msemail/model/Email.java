package com.microservices.msemail.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.microservices.msemail.model.enums.StatusEmail;

import lombok.Data;

@Data
@Entity
public class Email implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String ownerRef;
	
	private String emailFrom;
	
	private String emailTo;
	
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	private LocalDateTime sendDateEmail;
	
	private StatusEmail statusEmail;
	
}
