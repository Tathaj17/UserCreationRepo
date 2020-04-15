package com.createUser.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.createUser.user.dao.UserRepository;
import com.createUser.user.model.User;

@Component
public class UserService {
	@Autowired
	private UserRepository repos;
	public User addUser(User user) {
		return repos.save(user);
	}
	public List<User> getUsers()
	{
		return(repos.findAll());
	}
	public User getSpecificUser(Long id)
	{
		return (repos.findById(id).orElse(null));
	}
	public Long deleteUser(User user)
	{
		repos.delete(user);
		return (repos.count());
		
	}

}
