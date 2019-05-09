package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.StudentDetail;

public interface StudentService {

	public UUID save(StudentDetail studentdetail) throws Throwable;

	public void delete(UUID studentdetail) throws Throwable;

	public void update(UUID studentdetail,Integer phoneNo) throws Throwable;

	public List<StudentDetail> getAllStudents() throws Throwable;

}
