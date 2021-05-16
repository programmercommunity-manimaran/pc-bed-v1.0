package com.programmer.community.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.programmer.community.user.asset.Paths;
import com.programmer.community.user.model.Response;
import com.programmer.community.user.model.User;
import com.programmer.community.user.service.UserServices;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	UserServices userServices;

	@GetMapping(Paths.User.GET_ALL)
	public @ResponseBody List<User> getAll() {
		return this.userServices.getAll();
	}

	@GetMapping(Paths.User.GET_BY_ID)
	public @ResponseBody User getById(@PathVariable("id") String id) {
		return this.userServices.getById(id);
	}
	
	
	@GetMapping(Paths.User.GET_BY_EMAIL)
	public @ResponseBody User getByEmail(@PathVariable("email") String email) {
		return userServices.getByMailId(email);
		
	}
	
	@PostMapping(Paths.User.ADD)
	public @ResponseBody Response add(@RequestBody User user) {
		return this.userServices.add(user);
	}

	@PutMapping(Paths.User.UPDATE)
	public @ResponseBody Response update(@RequestBody User user) {
		return this.userServices.update(user);
	}

	@DeleteMapping(Paths.User.DELETE_BY_ID)
	public @ResponseBody Response deleteById(@PathVariable("email") String email) {
		return this.userServices.deleteByEmail(email);
	}
}
