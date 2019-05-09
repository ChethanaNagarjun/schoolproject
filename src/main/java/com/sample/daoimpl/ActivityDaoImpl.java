package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.ActivityDao;
import com.sample.model.Activity;

@Repository
@Transactional

public class ActivityDaoImpl extends BaseDaoImpl implements ActivityDao {
	@Override
	public UUID save(Activity activity) throws Throwable {
		return (UUID) getSession().save(activity);
	}

	@Override
	public Activity getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Activity.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Activity) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public Activity getByActivityName(String activityName) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Activity.class).add(Restrictions.eq("activityName", activityName));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Activity) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public void delete(Activity activity) throws Throwable {
		getSession().delete(activity);
	}

	@Override
	public void update(Activity activity) throws Throwable {
		getSession().update(activity);
	}

	@Override
	public List<Activity> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Activity.class);
			List<Activity> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}
}
