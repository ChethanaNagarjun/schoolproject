package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.enums.Authorities;
import com.sample.model.Authority;
import com.sample.dao.UserAuthorityDao;
import com.sample.dao.UserDao;
import com.sample.model.User;
import com.sample.modelmapper.UserDetail;
import com.sample.service.UserService;
import com.sample.model.UserAuthority;

@Service
@Transactional

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserAuthorityDao userAuthorityDao;

	@Autowired
	private StandardPasswordEncoder passwordEncoder;

	@Override
	public UUID save(UserDetail userDetail) throws Throwable {
		UUID id = null;
		try {
			id = userDao.save(parseUserDetailToUser(userDetail));
			
			UserAuthority userAuthority = new UserAuthority();
			userAuthority.setFkeyAuthorityId(new Authority(Authorities.ROLE_USER.getValue()));
			userAuthority.setFkeyUserId(new User(id));
			
			userAuthorityDao.save(userAuthority);

		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}

		return id;

	}

	private UserDetail parseUserToUserDetail(User user) throws Throwable {
		UserDetail userDetail = new UserDetail();

		if (user.getId() != null) {
			userDetail.setId(user.getId());
		}

		if (user.getUserName() != null) {
			userDetail.setUserName(user.getUserName());
		}
		if (user.getEmail() != null) {
			userDetail.setEmail(user.getEmail());
		}

		if (user.getPassword() != null) {
			userDetail.setPassword(user.getPassword());
		}

		if (user.getActivated() != null) {
			userDetail.setActivated(user.getActivated());
		}

		if (user.getActivationKey() != null) {
			userDetail.setActivationKey(user.getActivationKey());
		}
		if (user.getResetPasswordKey() != null) {
			userDetail.setResetPasswordKey(user.getResetPasswordKey());
		}

		return userDetail;
	}

	private User parseUserDetailToUser(UserDetail userDetail) throws Throwable {

		User user = new User();

		if (userDetail.getId() != null) {
			user.setId(userDetail.getId());
		}

		if (userDetail.getUserName() != null) {
			user.setUserName(userDetail.getUserName());
		}
		if (userDetail.getEmail() != null) {
			user.setEmail(userDetail.getEmail());
		}

		if (userDetail.getPassword() != null) {
			user.setPassword(userDetail.getPassword());
		}

		user.setActivated(true);
		user.setActivationKey(RandomStringUtils.randomAlphanumeric(8));
		if(userDetail.getPassword() != null){
			String hashedPassword = passwordEncoder.encode(userDetail.getPassword());
			user.setPassword(hashedPassword);
		}

		return user;
	}

	@Override
	public void delete(UUID id) throws Throwable {
        User user = userDao.getById(id);
		userDao.delete(user);
	}

	@Override
	public void update(UUID id) throws Throwable {
		User user = userDao.getById(id);
		userDao.update(user);

	}

	@Override
	public List<UserDetail> getAllUsers() throws Throwable {
		List<User> userList = userDao.getAll();
		List<UserDetail> userDetailList = new ArrayList<UserDetail>();

		for (User user : userList) {
			userDetailList.add(parseUserToUserDetail(user));
		}
		return userDetailList;
	}

}
