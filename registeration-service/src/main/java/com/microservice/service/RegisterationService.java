package com.microservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dto.UserRequest;
import com.microservice.dto.UserResponse;
import com.microservice.model.UserInfo;
import com.microservice.repository.RegisterationRepository;



@Service
public class RegisterationService {
	@Autowired
	private RegisterationRepository repo;

	public UserInfo createNewUser(UserRequest info) {
		UserInfo userInfo  = UserInfo.builder()
				.name(info.getName())
				.email(info.getEmail())
				.password(info.getPassword())
				.number(info.getNumber())
				.build();
		return repo.save(userInfo);
	}

	public List<UserResponse> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll().parallelStream().map(userInfo->mapToUserResponse(userInfo))
		 .collect(Collectors.toList());
	}

	public UserResponse mapToUserResponse(UserInfo userInfo){
		return UserResponse.builder()
		.name(userInfo.getName())
		.email(userInfo.getEmail())
		.number(userInfo.getNumber())
		.build();
	}
}
