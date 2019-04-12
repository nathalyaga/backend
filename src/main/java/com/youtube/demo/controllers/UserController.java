package com.youtube.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtube.demo.model.User;
import com.youtube.demo.service.UserService;
import com.youtube.demo.util.QueryResult;
import com.youtube.demo.util.RestResponse;

@RestController
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	protected ObjectMapper objectMapper;
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.objectMapper = new ObjectMapper();
		User user = this.objectMapper.readValue(userJson, User.class);
		
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),"Los campos obligatorios estan vacio");
		}
		
		this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(), "Insercion exitosa");
		
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();		
	}
	
	private boolean validate (User user){		
		boolean isvalidate=true;
		
		if(StringUtils.trimToNull(user.getFirstName())==null) {
			isvalidate=false;
		}
		
		if(StringUtils.trimToNull(user.getFirstSurname())==null) {
			isvalidate=false;
		}
		
		if(StringUtils.trimToNull(user.getPhone())==null) {
			isvalidate=false;
		}
		
		if(StringUtils.trimToNull(user.getAddress())==null) {
			isvalidate=false;
		}
		return isvalidate;		
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUSer(@RequestBody String userJson) throws Exception {
		this.objectMapper = new ObjectMapper();
		User user = this.objectMapper.readValue(userJson, User.class);
		if(user.getId() == 0) {
			throw new Exception("El id es nulo");
			
		}
		this.userService.deleteAll(user.getId());
		
		
	}

}
