package com.sample.modelmapper;

import java.util.UUID;

public class ActivityDetail {
	
	private UUID id;
	private String activityName;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}



}
