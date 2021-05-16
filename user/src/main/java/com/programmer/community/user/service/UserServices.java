package com.programmer.community.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmer.community.user.exception.DataAlreadyExistsException;
import com.programmer.community.user.exception.DataNotFoundException;
import com.programmer.community.user.model.Response;
import com.programmer.community.user.model.User;
import com.programmer.community.user.repository.UserDao;

@Service
public class UserServices {

	@Autowired
	UserDao userDao;

	public List<User> getAll() {
		return this.userDao.findAll();
	}

	public User getById(String id) {
		if (this.userDao.existsById(id)) {
			return this.userDao.findById(id).get();
		}
		throw new DataNotFoundException("user not found");
	}
    
	
	//GetBy Mailid
	public User getByMailId(String email) {
		
		if(userDao.findByEmail(email) != null) {
			return userDao.findByEmail(email);
		}
		
		throw new DataNotFoundException("user not found");
	}

	//Post User With Email
	public Response add(User user) {
		if (userDao.findByEmail(user.getEmail()) != null) {
			throw new DataAlreadyExistsException("User already exists");
		}
		 userDao.save(user);
		return Response.getSuccess();
	}

	public Response update(User user) {
		if (userDao.findByEmail(user.getEmail()) != null) {
			userDao.save(user);
			return Response.getSuccess();
		}
		throw new DataNotFoundException("user not found");
	}

	public Response deleteByEmail(String email) {
		if (userDao.findByEmail(email) != null) {
			this.userDao.deleteByEmail(email);
			return Response.getSuccess();
		}
		throw new DataNotFoundException("user not found");
	}
}
