package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.Standard;

public interface StandardDao {
	public UUID save(Standard standard) throws Throwable;

	public Standard getById(UUID id) throws Throwable;

	public Standard getByName(String name) throws Throwable;

	public void delete(Standard standard) throws Throwable;

	public void update(Standard standard) throws Throwable;

	public List<Standard> getAll() throws Throwable;

}
