package com.youtube.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@SuppressWarnings("unchecked")
	User save (User user);
	
}
