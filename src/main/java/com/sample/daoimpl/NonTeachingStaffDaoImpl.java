package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.NonTeachingStaffDao;
import com.sample.model.NonTeachingStaff;

@Repository
@Transactional
public class NonTeachingStaffDaoImpl extends BaseDaoImpl implements NonTeachingStaffDao {
	@Override
	public UUID save(NonTeachingStaff nonteachingstaff) throws Throwable {
		return (UUID) getSession().save(nonteachingstaff);
	}

	@Override
	public NonTeachingStaff getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public NonTeachingStaff getByName(String name) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class).add(Restrictions.eq("name", name));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public NonTeachingStaff getByYearOfJoin(Integer yearOfJoin) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class)
					.add(Restrictions.eq("yearOfJoin", yearOfJoin));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public NonTeachingStaff getByEmailId(String emailId) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class)
					.add(Restrictions.eq("emailId", emailId));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public NonTeachingStaff getByPhoneNo(Integer phoneNo) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class)
					.add(Restrictions.eq("phoneNo", phoneNo));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public NonTeachingStaff getBySalary(Integer salary) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class)
					.add(Restrictions.eq("salary", salary));
			if (criteria.list().isEmpty()) {
				return null;
			}

			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public NonTeachingStaff getByActivityId(Integer activityId) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class)
					.add(Restrictions.eq("activityId", activityId));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (NonTeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public void delete(NonTeachingStaff nonteachingstaff) throws Throwable {
		getSession().delete(nonteachingstaff);
	}

	@Override
	public void update(NonTeachingStaff nonteachingstaff) throws Throwable {
		getSession().update(nonteachingstaff);
	}

	@Override
	public List<NonTeachingStaff> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(NonTeachingStaff.class);
			List<NonTeachingStaff> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

}
