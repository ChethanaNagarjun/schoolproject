package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.Activity;

public interface ActivityDao {
	public UUID save(Activity activity) throws Throwable;

	public Activity getById(UUID id) throws Throwable;

	public Activity getByActivityName(String activityName) throws Throwable;

	public void delete(Activity activity) throws Throwable;

	public void update(Activity activity) throws Throwable;

	public List<Activity> getAll() throws Throwable;

}
