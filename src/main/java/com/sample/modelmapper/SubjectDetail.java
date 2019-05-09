package com.sample.modelmapper;

import java.util.UUID;

public class SubjectDetail {
	
	private UUID id;
	private String subjectName;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}



}
