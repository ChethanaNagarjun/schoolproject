package com.sample.daoimpl;

import java.util.UUID;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.StudentDao;
import com.sample.model.Student;

@Repository
@Transactional

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao {
	@Override
	public UUID save(Student student) throws Throwable {
		return (UUID) getSession().save(student);
	}

	@Override
	public Student getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByFirstName(String firstName) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("firstName", firstName));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByLastName(String lastName) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("lastName", lastName));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByGender(String gender) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("gender", gender));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public Student getByDateOfBirth(Integer dateOfBirth) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class)
					.add(Restrictions.eq("dateOfBirth", dateOfBirth));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByAge(Integer age) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("age", age));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByCity(String city) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("city", city));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByState(String state) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("state", state));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByZipCode(Integer zipCode) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("zipCode", zipCode));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByPhoneNo(Integer phoneNo) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("phoneNo", phoneNo));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public Student getByAddmissionYear(Integer addmissionYear) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class)
					.add(Restrictions.eq("addmissionYear", addmissionYear));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (Student) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public void delete(Student student) throws Throwable {
		getSession().delete(student);
	}

	@Override
	public void update(Student student) throws Throwable {
		getSession().update(student);
	}

	@Override
	public List<Student> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(Student.class);
			List<Student> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}

			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}
	
	@Override
	public Integer getMaximumRollNo(Integer classId)throws Throwable 
	{
		try {
			Criteria criteria = getSession().createCriteria(Student.class).add(Restrictions.eq("studentClassId", classId));

			criteria.addOrder(Order.desc("rollNo"));
			criteria.setMaxResults(1);
			Integer maxRoll = (Integer)criteria.uniqueResult();

			return maxRoll;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
		
	}

}
