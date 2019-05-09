package com.sample.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sample.dao.UserAuthorityDao;
import com.sample.model.UserAuthority;

@Repository
@Transactional
public class UserAuthorityDaoImpl extends BaseDaoImpl implements UserAuthorityDao {

	@Override
	public UUID save(UserAuthority userAuthority) throws Throwable {

		return (UUID) getSession().save(userAuthority);
	}

	@Override
	public UserAuthority getById(UUID id) throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(UserAuthority.class).add(Restrictions.eq("id", id));
			if (criteria.list().isEmpty()) {
				return null;
			}
			return (UserAuthority) criteria.list().get(0);

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}

	@Override
	public void delete(UserAuthorityDao userAuthority) throws Throwable {
		getSession().delete(userAuthority);
	}

	@Override
	public void update(UserAuthorityDao userAuthority) throws Throwable {
		getSession().update(userAuthority);

	}

	@Override
	public List<UserAuthority> getAll() throws Throwable {
		try {
			Criteria criteria = getSession().createCriteria(UserAuthority.class);
			List<UserAuthority> list = criteria.list();
			if (list.isEmpty()) {
				return null;
			}
			return list;

		} catch (Throwable ex) {
			throw new Throwable(ex);
		}

	}
}
