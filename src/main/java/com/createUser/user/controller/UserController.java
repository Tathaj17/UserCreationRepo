package com.createUser.user.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createUser.user.businessImpl.buisinessImplementationForService;
import com.createUser.user.exception.UserNotFoundException;
import com.createUser.user.model.Response;
import com.createUser.user.model.User;


@RestController
@RequestMapping("/userCreation")
@CrossOrigin
public class UserController {
	
	@Autowired
	private buisinessImplementationForService bisImpl;
	
	@PostMapping("/inertUser")
	public ResponseEntity<?> inertUser(@Valid @RequestBody User user,BindingResult result) throws Exception
	{
		if(result.hasErrors())
        {
            HashMap<String,String> errorMap= new HashMap<>();
            for(FieldError fd:result.getFieldErrors())
            {
                errorMap.put(fd.getField(),fd.getDefaultMessage()) ;
            }
            return  new ResponseEntity<HashMap<String,String> >(errorMap, HttpStatus.BAD_REQUEST);
        }
		try {
			return  new ResponseEntity<User>(bisImpl.addUser(user), HttpStatus.CREATED);
		}catch(Exception ex){
		  throw new Exception("Not Inserted");
		  }
	}
	
	@PutMapping("/inertUser")
	public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody User user,BindingResult result) throws Exception
	{
		if(result.hasErrors())
        {
            HashMap<String,String> errorMap= new HashMap<>();
            for(FieldError fd:result.getFieldErrors())
            {
                errorMap.put(fd.getField(),fd.getDefaultMessage()) ;
            }
            return  new ResponseEntity<HashMap<String,String> >(errorMap, HttpStatus.BAD_REQUEST);
        }
		try {
			return  new ResponseEntity<User>(bisImpl.addUser(user), HttpStatus.CREATED);
		}catch(Exception ex){
		  throw new Exception("Not Inserted");
		  }
	}
	
	
	@DeleteMapping("/deleteUser")
	public Response deleteUser(@RequestBody User user) throws Exception
	{
			Long l=bisImpl.deleteUser(user);
			if(l==0)
			{
			  return new Response("No user Found",true);
			}
			  return new Response(l.toString(),true);
		}
	
	@GetMapping("/getUserwithID/{id}")
	public  ResponseEntity<User> getUserwithID(@PathVariable("id") Long id) throws UserNotFoundException
	{
		User user=null;
		try {
			user=bisImpl.getSpecificUser(id);
			if(user.equals(null)) {
				 throw new UserNotFoundException("User not found");
			}
			 return new ResponseEntity<User>(user,HttpStatus.FOUND);
		}catch(UserNotFoundException ex){
			  throw new UserNotFoundException("User not found");
	   }
		
	}
	
	@GetMapping("/getUsers")
	 public  ResponseEntity<List<User>> getUsers() throws UserNotFoundException
	{
		try {
		 List<User>	lUserList=bisImpl.getUsers();
		
		 if( lUserList.size()<1) {
			 throw new UserNotFoundException("No Users found");
		 }
		return new ResponseEntity<List<User>>(bisImpl.getUsers(),HttpStatus.FOUND);
		}catch(Exception ex){
			 throw new UserNotFoundException("No Users found");
	   }
	}
	
	

}
