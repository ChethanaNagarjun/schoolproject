package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.UserDao;
import com.sample.model.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	@Override
	public UUID save(User user) throws Throwable {
		return (UUID) getSession().save(user);
	}

	@Override
	public User getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public User getByUserName(String userName) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.eq("userName", userName));
			if (criteria.list().isEmpty()) {
				return null;
			}

			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public User getByEmail(String email) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.eq("email", email));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public User getByPassword(String password) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.eq("password", password));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);

		}
	}

	@Override
	public User getByActivated(Boolean activated) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.eq("activated", activated));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public User getByActivationKey(String activationKey) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class)
					.add(Restrictions.eq("activationKey", activationKey));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public User getByResetPasswordKey(String resetPasswordKey) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class)
					.add(Restrictions.eq("resetActivationKey", resetPasswordKey));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (User) criteria.list().get(0);
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

	@Override
	public void delete(User user) throws Throwable {
		getSession().delete(user);
	}

	@Override
	public void update(User user) throws Throwable {
		getSession().update(user);
	}

	@Override
	public List<User> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(User.class);
			List<User> list = criteria.list();
			if (criteria.list().isEmpty()) {
				return null;
			}
			return list;
		} catch (Throwable ex) {
			throw new Throwable(ex);
		}
	}

}
