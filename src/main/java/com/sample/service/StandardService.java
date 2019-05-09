package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.StandardDetail;

public interface StandardService {

	public UUID save(StandardDetail standarddetail) throws Throwable;

	public void delete(UUID standarddetail) throws Throwable;

	public void update(UUID standarddetail,String name ) throws Throwable;

	public List<StandardDetail> getAllStandards() throws Throwable;

}
