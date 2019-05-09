package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.SubjectDao;
import com.sample.model.Subject;

@Repository
@Transactional
public class SubjectDaoImpl extends BaseDaoImpl implements SubjectDao {
	@Override
	public UUID save(Subject subject) throws Throwable {
		return (UUID) getSession().save(subject);
	}

	@Override
	public Subject getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Subject.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Subject) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Subject getByName(String name) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Subject.class).add(Restrictions.eq("name", name));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Subject) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public void delete(Subject subject) throws Throwable {
		getSession().delete(subject);
	}

	@Override
	public void update(Subject subject) throws Throwable {
		getSession().update(subject);
	}

	@Override
	public List<Subject> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Subject.class);
			List<Subject> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

}
