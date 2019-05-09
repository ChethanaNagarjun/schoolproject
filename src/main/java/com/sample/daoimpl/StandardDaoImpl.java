package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.StandardDao;
import com.sample.model.Standard;

@Repository
@Transactional
public class StandardDaoImpl extends BaseDaoImpl implements StandardDao {
	@Override
	public UUID save(Standard classes) throws Throwable {
		return (UUID) getSession().save(classes);
	}

	@Override
	public Standard getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Standard.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Standard) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Standard getByName(String name) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Standard.class).add(Restrictions.eq("name", name));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Standard) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public void delete(Standard standard) throws Throwable {
		getSession().delete(standard);
	}

	@Override
	public void update(Standard standard) throws Throwable {
		getSession().update(standard);
	}

	@Override
	public List<Standard> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Standard.class);
			List<Standard> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

}
