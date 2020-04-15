package com.createUser.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createUser.user.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
