package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.TeachingStaffDao;
import com.sample.model.TeachingStaff;

@Repository
@Transactional
public class TeachingStaffDaoImpl extends BaseDaoImpl implements TeachingStaffDao {
	@Override
	public UUID save(TeachingStaff teachingstaff) throws Throwable {
		return (UUID) getSession().save(teachingstaff);
	}

	@Override
	public TeachingStaff getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByName(String name) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class).add(Restrictions.eq("name", name));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByYearOfJoin(Integer yearOfJoin) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class)
					.add(Restrictions.eq("yearOfJoin", yearOfJoin));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByEducationDetails(String educationDetails) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class)
					.add(Restrictions.eq("educationDetails", educationDetails));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByEmailId(String emailId) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class)
					.add(Restrictions.eq("emailId", emailId));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByPhoneNo(Integer phoneNo) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class)
					.add(Restrictions.eq("phoneNo", phoneNo));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getBySalary(Integer salary) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class).add(Restrictions.eq("salary", salary));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getByClassId(Integer classId) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class)
					.add(Restrictions.eq("classId", classId));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public TeachingStaff getBySubjectId(Integer subjectId) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class).add(Restrictions.eq("subjectId", subjectId));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (TeachingStaff) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public void delete(TeachingStaff teachingstaff) throws Throwable {
		getSession().delete(teachingstaff);
	}

	@Override
	public void update(TeachingStaff teachingstaff) throws Throwable {
		getSession().update(teachingstaff);
	}

	@Override
	public List<TeachingStaff> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(TeachingStaff.class);
			List<TeachingStaff> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

}
