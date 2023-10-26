package com.microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.model.UserInfo;

@Repository
public interface RegisterationRepository extends MongoRepository<UserInfo, String>{

}
