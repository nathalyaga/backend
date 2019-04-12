package com.youtube.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.demo.dao.UserRepository;
import com.youtube.demo.model.User;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	protected UserRepository userRepository;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public void deleteAll(long id) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(id);
	}

}
