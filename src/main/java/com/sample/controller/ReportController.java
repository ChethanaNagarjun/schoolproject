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
import com.sample.service.ReportService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportservice;
	
	@RequestMapping(value = "/helloreport", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public String helloreport()throws Throwable {
		String response = null;
		try {
			response = "hello Report";
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/report", method = RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> addReport(@RequestBody ReportDetail reportDetail, HttpServletRequest httpServletRequest)
			throws Throwable {
		GenericResponse genericResponse = new GenericResponse();
		try {
			UUID id = reportservice.save(reportDetail);
			genericResponse.setId(id.toString());
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<GenericResponse> getAllReport() throws Throwable {
		GenericResponse<ReportDetail> genericResponse = new GenericResponse<ReportDetail>();
		List<ReportDetail> reportDetailList = reportservice.getAllReports();
		
		genericResponse.setDetails(reportDetailList);
		System.out.println("hello");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value ="/report/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<GenericResponse>DeleteReport(@PathVariable ("id") String id) throws Throwable{
		GenericResponse<ReportDetail>genericResponse = new GenericResponse<ReportDetail>();
		UUID uuid = UUID.fromString(id);
		reportservice.delete(uuid);
		genericResponse.setMessages("Record deleted successfully");
		return new ResponseEntity<>(genericResponse, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/report/{id}",method = RequestMethod.PUT)
	public ResponseEntity<GenericResponse>UpdateReport(@RequestBody ReportDetail reportdetail,@PathVariable("id")String id)throws Throwable{
		GenericResponse<ReportDetail>genericResponse = new GenericResponse<ReportDetail>();
		UUID uuid = UUID.fromString(id);
		reportservice.update(uuid,reportdetail.getReportStatus());
		genericResponse.setMessages("Record updated successfully");
		return new ResponseEntity<>(genericResponse,HttpStatus.ACCEPTED);
	}

}
