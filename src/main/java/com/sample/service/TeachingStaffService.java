package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.TeachingStaffDetail;

public interface TeachingStaffService {

	public UUID save(TeachingStaffDetail teachingstaffdetail) throws Throwable;

	public void delete(UUID teachingstaffdetail) throws Throwable;

	public void update(UUID teachingstaffdetail,Integer salary) throws Throwable;

	public List<TeachingStaffDetail> getAllTeachingStaffs() throws Throwable;

}
