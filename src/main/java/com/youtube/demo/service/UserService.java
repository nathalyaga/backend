package com.youtube.demo.service;

import java.util.List;

import com.youtube.demo.model.User;

public interface UserService {

	/*
	 * Guarda los usuarios
	 */
	User save(User user);

	/*
	 * Recupera los usuarios
	 * 
	 */
	List<User> findAll();
	
	/**
	 * Elimina usuario dado el id
	 * @param id
	 */

	void deleteAll(long id);

}
