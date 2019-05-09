package com.sample.modelmapper;

import java.util.UUID;

public class TeachingStaffDetail {

	private UUID id;
	private String name;
	private Integer yearOfJoin;
	private String educationDetails;
	private String emailId;
	private Integer phoneNo;
	private Integer salary;
	private String standardId;
	private String subjectId;

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

	public String getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(Integer phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getStandardId() {
		return standardId;
	}

	public void setStandardId(String standardId) {
		this.standardId = standardId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

}
