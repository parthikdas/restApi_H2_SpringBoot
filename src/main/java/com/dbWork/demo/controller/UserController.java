package com.dbWork.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dbWork.demo.entity.UserData;
import com.dbWork.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public List<UserData> showAllUsers() { // Method to get all the users data
		return service.showAll();
	}
	
	@GetMapping("/{id}")
	public UserData showUser(@PathVariable int id) { // Method to get a user data 
		return service.getUser(id);
	}
	
	@PutMapping("/{id}")
	public UserData updateUser(@PathVariable int id, @RequestBody UserData user) {
		return service.updateUser(id, user);
	}
	
	@PostMapping("/")
	public UserData createUser(@RequestBody UserData user) {
		return service.saveUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) { // Method to delete a user
		service.deleteUser(id);
	}
}
