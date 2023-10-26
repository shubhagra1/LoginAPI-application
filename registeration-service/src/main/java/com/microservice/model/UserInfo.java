package com.microservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "user-info")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	@Id
	private String id;
	private String name;
	private String email;
	private long number;
	private String password;

	public UserInfo(String email, String password) {
		// TODO Auto-generated constructor stub
		this.email = email;
		this.password = password;
		
	}
}
