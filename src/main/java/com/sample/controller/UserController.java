package com.sample.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sample.modelmapper.GenericResponse;
import com.sample.modelmapper.UserDetail;
import com.sample.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/helloUser", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloUser() throws Throwable {
		String response = null;
		try {
			response = "Hello User";
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String addUser(@RequestBody UserDetail userdetail, HttpServletRequest httpServletRequest) throws Throwable {
		String response = null;
		try {
			UUID id = userservice.save(userdetail);
			response = id.toString();
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllUser() throws Throwable {
		GenericResponse<UserDetail> genericResponse = new GenericResponse<UserDetail>();
		List<UserDetail> userDetailList = userservice.getAllUsers();
		genericResponse.setDetails(userDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value ="/user/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse>DeleteUser(@PathVariable ("id") String id) throws Throwable{
		GenericResponse<UserDetail>genericResponse = new GenericResponse<UserDetail>();
		UUID uuid = UUID.fromString(id);
		userservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse>UpdateUser(@PathVariable("id")String id)throws Throwable{
		GenericResponse<UserDetail>genericResponse = new GenericResponse<UserDetail>();
		UUID uuid = UUID.fromString(id);
		userservice.update(uuid);
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}


}
