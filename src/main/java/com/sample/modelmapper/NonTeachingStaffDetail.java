package com.sample.modelmapper;

import java.util.UUID;

import com.sample.model.Activity;

public class NonTeachingStaffDetail {

	private UUID id;
	private String name;
	private Integer yearOfJoin;
	private String emailId;
	private Integer phoneNo;
	private Integer salary;
	private String activityId;
	private Activity activity;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOfJoin() {
		return yearOfJoin;
	}

	public void setYearOfJoin(Integer yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}

	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId){
		
		this.emailId = emailId;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}


}
