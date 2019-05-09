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
import com.sample.modelmapper.NonTeachingStaffDetail;
import com.sample.modelmapper.TeachingStaffDetail;
import com.sample.service.TeachingStaffService;

@Controller
@RequestMapping("/teachingstaff")
public class TeachingStaffController {

	@Autowired
	private TeachingStaffService teachingstaffservice;
	
	@RequestMapping(value = "/helloTeachingStaff", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloTeachingStaff() throws Throwable {
		String response = null;
		try {
			response = "hello TeachingStaff";
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/teachingstaff", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> addTeachingStaff(
			@RequestBody TeachingStaffDetail teachingstaffDetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		GenericResponse genericResponse = new GenericResponse();
		try {
			UUID id = teachingstaffservice.save(teachingstaffDetail);
			genericResponse.setId(id.toString());
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/teachingstaff", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllTeachingStaff() throws Throwable {
		GenericResponse<TeachingStaffDetail> genericResponse = new GenericResponse<TeachingStaffDetail>();
		List<TeachingStaffDetail> teachingstaffDetailList = teachingstaffservice.getAllTeachingStaffs();
		genericResponse.setDetails(teachingstaffDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value ="/teachingstaff/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse>DeleteTeachingstaff(@PathVariable ("id") String id) throws Throwable{
		GenericResponse<TeachingStaffDetail>genericResponse = new GenericResponse<TeachingStaffDetail>();
		UUID uuid = UUID.fromString(id);
		teachingstaffservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/teachingstaff/{id}",method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse>UpdateTeachingstaff(@RequestBody TeachingStaffDetail teachingstaffDetail,@PathVariable("id")String id)throws Throwable{
		GenericResponse<TeachingStaffDetail>genericResponse = new GenericResponse<TeachingStaffDetail>();
		UUID uuid = UUID.fromString(id);
		teachingstaffservice.update(uuid,teachingstaffDetail.getSalary());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}


}
