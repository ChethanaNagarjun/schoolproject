package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.User;

public interface UserDao {

	public UUID save(User user) throws Throwable;

	public User getById(UUID id) throws Throwable;

	public User getByUserName(String userName) throws Throwable;

	public User getByEmail(String email) throws Throwable;

	public User getByPassword(String password) throws Throwable;

	public User getByActivated(Boolean activated) throws Throwable;

	public User getByActivationKey(String activationKey) throws Throwable;

	public User getByResetPasswordKey(String resetPasswordKey) throws Throwable;

	public void delete(User user) throws Throwable;

	public void update(User user) throws Throwable;

	public List <User> getAll() throws Throwable;

}
