package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.ActivityDao;
import com.sample.model.Activity;
import com.sample.modelmapper.ActivityDetail;
import com.sample.service.ActivityService;

@Service
@Transactional

public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;

	@Override
	public UUID save(ActivityDetail activityDetail) throws Throwable {
		UUID id = null;
		try {
			id = activityDao.save(parseActivityDetailToActivity(activityDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;

	}

	private Activity parseActivityDetailToActivity(ActivityDetail activityDetail) {
		Activity activity = new Activity();
		if (activityDetail.getId() != null) {
			activity.setId(activityDetail.getId());
		}

		if (activityDetail.getActivityName() != null) {
			activity.setActivityName(activityDetail.getActivityName());
		}
		return activity;
	}

	private ActivityDetail parseActivityToActivityDetail(Activity activity)

	{
		ActivityDetail activityDetail = new ActivityDetail();
		if (activity.getId() != null) {
			activityDetail.setId(activity.getId());
		}

		if (activity.getActivityName() != null) {
			activityDetail.setActivityName(activity.getActivityName());
		}
		return activityDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		Activity activity = activityDao.getById(id);
		activityDao.delete(activity);
	}

	@Override
	public void update(UUID id, String activityName) throws Throwable {
		Activity activity = activityDao.getById(id);
		activity.setActivityName(activityName);
		activityDao.update(activity);
	}

	@Override
	public List<ActivityDetail> getAllActivites() throws Throwable {
		List<Activity> activityList = activityDao.getAll();
		List<ActivityDetail> activityDetailList = new ArrayList<ActivityDetail>();

		for (Activity activity : activityList) {
			activityDetailList.add(parseActivityToActivityDetail(activity));
		}
		return activityDetailList;

	}

}
