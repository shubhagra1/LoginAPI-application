package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.UserRequest;
import com.microservice.dto.UserResponse;
import com.microservice.model.UserInfo;
import com.microservice.service.RegisterationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/register")
@Slf4j
public class RegisterationController {
	
	@Autowired
	private RegisterationService service;
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserRequest userInfo){
		log.info("Create new User logging");
		UserInfo info = service.createNewUser(userInfo);
		if(info==null)
			return new ResponseEntity<String>("User detail not saved, please try again" , HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>("Registeration Successful",  HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUser(){
		List<UserResponse> userInfos = service.getAllUser();
		return new ResponseEntity<List<UserResponse>>(userInfos,HttpStatus.OK);
	}
}
