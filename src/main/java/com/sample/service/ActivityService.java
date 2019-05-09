package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.ActivityDetail;

public interface ActivityService {

	public UUID save(ActivityDetail activityDetail) throws Throwable;

	public void delete(UUID activityDetail) throws Throwable;

	public void update(UUID activityDetail, String activityName) throws Throwable;

	public List<ActivityDetail> getAllActivites() throws Throwable;

}
