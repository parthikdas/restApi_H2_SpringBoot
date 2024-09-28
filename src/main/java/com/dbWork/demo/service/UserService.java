package com.dbWork.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbWork.demo.entity.UserData;
import com.dbWork.demo.repository_DAO.UserRepository;

@org.springframework.stereotype.Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public List<UserData> showAll() { // Show all
		return repo.findAll();
	}
	
	public UserData saveUser(UserData user) { // Save user
		return repo.save(user);
	}
	
	public UserData updateUser(int id, UserData user) { // Update user
		Optional<UserData> existingUserOptional = repo.findById(id);
		if(existingUserOptional.isPresent()) {
			UserData userFound = existingUserOptional.get();
			userFound.setEmail(user.getEmail());
			userFound.setName(user.getName());
			userFound.setPassword(user.getPassword());
			return repo.save(userFound);
		} else {
			return null;
		}
	}
	
	public UserData getUser(int id) {
		return repo.findById(id).orElse(null); // Will get the details of that user
	}
	
	public void deleteUser(int id) { // Will delete the user
		repo.deleteById(id);
	}
}
