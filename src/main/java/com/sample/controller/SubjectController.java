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
import com.sample.modelmapper.SubjectDetail;
import com.sample.service.SubjectService;


@Controller
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectservice;

	@RequestMapping(value = "/subject", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String addSubject(@RequestBody SubjectDetail subjectdetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		String response = null;
		try {
			UUID id = subjectservice.save(subjectdetail);
			response = id.toString();
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/subject", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllSubject() throws Throwable {
		GenericResponse<SubjectDetail> genericResponse = new GenericResponse<SubjectDetail>();
		List<SubjectDetail> subjectDetailList = subjectservice.getAllSubjects();
		genericResponse.setDetails(subjectDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value ="/subject/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse>DeleteSubject(@PathVariable ("id") String id) throws Throwable{
		GenericResponse<SubjectDetail>genericResponse = new GenericResponse<SubjectDetail>();
		UUID uuid = UUID.fromString(id);
		subjectservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/subject/{id}",method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse>UpdateSubject(@RequestBody SubjectDetail subjectdetail,@PathVariable("id")String id)throws Throwable{
		GenericResponse<SubjectDetail>genericResponse = new GenericResponse<SubjectDetail>();
		UUID uuid = UUID.fromString(id);
		subjectservice.update(uuid,subjectdetail.getSubjectName());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}


}
