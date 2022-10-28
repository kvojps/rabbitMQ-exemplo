package com.microservices.msemail.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.msemail.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
