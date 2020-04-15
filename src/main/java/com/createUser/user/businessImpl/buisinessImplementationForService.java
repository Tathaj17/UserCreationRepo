package com.createUser.user.businessImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.createUser.user.model.User;
import com.createUser.user.service.UserService;
@Component
public class buisinessImplementationForService{
	
	@Autowired
	private UserService userService;
	public User addUser(User user) {
		return(userService.addUser(user));		
	}
	public Long deleteUser(User user) {
		Long l=userService.deleteUser(user);
		return l;
		
	}
	public User getSpecificUser(Long id)
	{
		User us=userService.getSpecificUser(id);
		return us;
	}
	public List<User> getUsers()
	{
		List<User> lr=userService.getUsers();
		return lr;
	}
}
