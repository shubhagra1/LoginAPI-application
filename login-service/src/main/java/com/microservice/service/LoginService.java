package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.LoginResponse;
import com.microservice.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository repository;

	public String checkCredentials(LoginResponse response) {
		repository.findByUsername(response.getEmail());
		return null;
	}

}
