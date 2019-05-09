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

import com.sample.modelmapper.ActivityDetail;
import com.sample.modelmapper.GenericResponse;
import com.sample.service.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityservice;

	@RequestMapping(value = "/helloActivity", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloActivity()throws Throwable {
		String response = null;
		try {
			response = "hello Activity";
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}
	
	@RequestMapping(value = "/activity", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> addactivity(@RequestBody ActivityDetail activitydetail, HttpServletRequest httpServletRequest) throws Throwable {
		GenericResponse genericResponse = new GenericResponse();
		try {
			UUID id = activityservice.save(activitydetail);
			genericResponse.setId(id.toString());
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/activity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllActivity() throws Throwable {
		GenericResponse<ActivityDetail> genericResponse = new GenericResponse<ActivityDetail>();
		List<ActivityDetail> activityDetailList = activityservice.getAllActivites();

		genericResponse.setDetails(activityDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/activity/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse> DeleteActivity(@PathVariable("id") String id) throws Throwable {
		GenericResponse<ActivityDetail> genericResponse = new GenericResponse<ActivityDetail>();
		UUID uuid = UUID.fromString(id);
        activityservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/activity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse> UpdateActivity(@RequestBody ActivityDetail activityDetail, @PathVariable("id") String id)throws Throwable{
		GenericResponse<ActivityDetail> genericResponse = new GenericResponse<ActivityDetail>();
		UUID uuid = UUID.fromString(id);
		activityservice.update(uuid, activityDetail.getActivityName());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}
}