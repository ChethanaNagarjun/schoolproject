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
import com.sample.modelmapper.StudentDetail;
import com.sample.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;

	@RequestMapping(value = "/student", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String addStudent(@RequestBody StudentDetail studentdetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		String response = null;
		try {
			UUID id = studentservice.save(studentdetail);
			response = id.toString();
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllStudent() throws Throwable {
		GenericResponse<StudentDetail> genericResponse = new GenericResponse<StudentDetail>();
		List<StudentDetail> studentDetailList = studentservice.getAllStudents();
		genericResponse.setDetails(studentDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
  @RequestMapping(value ="/student/{id}",method = RequestMethod.DELETE)
  public ResponseEntity<GenericResponse>DeleteStudent(@PathVariable ("id") String id)throws Throwable{
	  GenericResponse<StudentDetail> genericResponse= new GenericResponse<StudentDetail>();
	  UUID uuid = UUID.fromString(id);
	  studentservice.delete(uuid);
	  genericResponse.setMessages("Record deleted successfully");
	  return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);  
  }
  @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
  public ResponseEntity<GenericResponse>UpdateStudent(@RequestBody StudentDetail studentDetail,@PathVariable ("id")String id)throws Throwable{
	  GenericResponse<StudentDetail>genericResponse = new GenericResponse<StudentDetail>();
	  UUID uuid = UUID.fromString(id);
	  studentservice.update(uuid,studentDetail.getPhoneNo());
	  genericResponse.setMessages("Record updated successfully");
	  return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
  }

}
