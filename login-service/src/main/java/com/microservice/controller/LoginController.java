package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.LoginResponse;
import com.microservice.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@Autowired
	LoginService service;

	@GetMapping
	public ResponseEntity<String> checkCredentials(@RequestBody LoginResponse response){
		String loginStatus = service.checkCredentials(response);
		return new ResponseEntity<String>(loginStatus,HttpStatus.OK);
	}
}
