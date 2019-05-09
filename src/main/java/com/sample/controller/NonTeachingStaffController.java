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
import com.sample.service.NonTeachingStaffService;

@Controller
@RequestMapping("/nonteachingstaff")
public class NonTeachingStaffController {

	@Autowired
	private NonTeachingStaffService nonteachingstaffservice;

	@RequestMapping(value = "/helloNonTeachingStaff", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloNonTeachingStaff() throws Throwable {
		String response = null;
		try {
			response = "hello NonTeachingStaff";
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/nonTeachingstaff", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> addNonTeachingStaff(
			@RequestBody NonTeachingStaffDetail nonteachingstaffDetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		GenericResponse genericResponse = new GenericResponse();
		try {
			UUID id = nonteachingstaffservice.save(nonteachingstaffDetail);
			genericResponse.setId(id.toString());
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/nonTeachingstaff", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllNonTeachingStaff() throws Throwable {
		GenericResponse<NonTeachingStaffDetail> genericResponse = new GenericResponse<NonTeachingStaffDetail>();
		List<NonTeachingStaffDetail> nonteachingstaffDetailList = nonteachingstaffservice.getAllNonTeachingStaffs();
		
		genericResponse.setDetails(nonteachingstaffDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/nonTeachingstaff/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse> DeleteNonTeachingStaff(@PathVariable("id") String id) throws Throwable {
		GenericResponse<NonTeachingStaffDetail> genericResponse = new GenericResponse<NonTeachingStaffDetail>();
		UUID uuid = UUID.fromString(id);
		nonteachingstaffservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/nonTeachingstaff/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse> UpdateNonTeachingStaff(
			@RequestBody NonTeachingStaffDetail nonteachingstaffDetail, @PathVariable("id") String id)
			throws Throwable {
		GenericResponse<NonTeachingStaffDetail> genericResponse = new GenericResponse<NonTeachingStaffDetail>();
		UUID uuid = UUID.fromString(id);
		nonteachingstaffservice.update(uuid, nonteachingstaffDetail.getEmailId(),nonteachingstaffDetail.getName());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
}
