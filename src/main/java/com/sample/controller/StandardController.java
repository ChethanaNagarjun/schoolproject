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
import com.sample.modelmapper.ReportDetail;
import com.sample.modelmapper.StandardDetail;
import com.sample.service.StandardService;

@Controller
@RequestMapping("/standard")
public class StandardController {

	@Autowired
	private StandardService standardservice;

	@RequestMapping(value = "/standard", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> addStandard(@RequestBody StandardDetail standardDetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		GenericResponse genericResponse = new GenericResponse();
		try {
			UUID id = standardservice.save(standardDetail);
			genericResponse.setId(id.toString());
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/standard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllStandard() throws Throwable {
		GenericResponse<StandardDetail> genericResponse = new GenericResponse<StandardDetail>();
		List<StandardDetail> standardDetailList = standardservice.getAllStandards();
		genericResponse.setDetails(standardDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value ="/standard/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse>DeleteStandard(@PathVariable ("id")String id)throws Throwable {
		GenericResponse<StandardDetail>genericResponse = new GenericResponse<StandardDetail>();
		UUID uuid = UUID.fromString(id);
		standardservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
		}
	
	@RequestMapping(value ="/standard/{id}",method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse>UpdateStandard(@RequestBody StandardDetail standarddetail,@PathVariable("id")String id)throws Throwable{
		GenericResponse<StandardDetail>genericResponse = new GenericResponse<StandardDetail>();
		UUID uuid = UUID.fromString(id);
		standardservice.update(uuid,standarddetail.getName());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}
}
