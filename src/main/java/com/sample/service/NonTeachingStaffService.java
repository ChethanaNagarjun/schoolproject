package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.NonTeachingStaffDetail;

public interface NonTeachingStaffService {

	public UUID save(NonTeachingStaffDetail nonteachingstaffdetail) throws Throwable;

	public void delete(UUID nonteachingstaff) throws Throwable;

	public void update(UUID nonteachingstaffdetail,String emailId,String name) throws Throwable;

	public List<NonTeachingStaffDetail> getAllNonTeachingStaffs() throws Throwable;

}
