package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.User;
import com.sample.model.UserAuthority;

public interface UserAuthorityDao {

public UUID save(UserAuthority userAuthority)throws Throwable;
	
	public UserAuthority getById(UUID id)throws Throwable;

	public void delete(UserAuthorityDao userAuthority)throws Throwable;

	public void update(UserAuthorityDao userAuthority)throws Throwable;

	public List<UserAuthority> getAll()throws Throwable;

}
