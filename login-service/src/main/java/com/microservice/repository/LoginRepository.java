package com.microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.model.UserLoginInfo;

@Repository
public interface LoginRepository extends MongoRepository<UserLoginInfo, String>{

	void findByUsername(String username);

}
