package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.Subject;

public interface SubjectDao {

	public UUID save(Subject subject) throws Throwable;

	public Subject getById(UUID Id) throws Throwable;

	public Subject getByName(String name) throws Throwable;

	public void delete(Subject subject) throws Throwable;

	public void update(Subject subject) throws Throwable;

	public List<Subject> getAll() throws Throwable;

}
