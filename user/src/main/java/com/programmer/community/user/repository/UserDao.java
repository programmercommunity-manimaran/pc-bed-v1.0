package com.programmer.community.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programmer.community.user.model.User;

public interface UserDao extends MongoRepository<User, String> {

}
