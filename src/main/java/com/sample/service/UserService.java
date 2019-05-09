package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.UserDetail;

public interface UserService {

	public UUID save(UserDetail userDetail) throws Throwable;

	public void delete(UUID userDetail) throws Throwable;

	public void update(UUID userDetail) throws Throwable;

	public List<UserDetail> getAllUsers() throws Throwable;

}
