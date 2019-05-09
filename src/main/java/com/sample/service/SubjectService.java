package com.sample.service;

import java.util.List;
import java.util.UUID;

import com.sample.modelmapper.SubjectDetail;

public interface SubjectService {

	public UUID save(SubjectDetail subjectdetail) throws Throwable;

	public void delete(UUID subjectdetail) throws Throwable;

	public void update(UUID subjectdetail,String subjectName) throws Throwable;

	public List<SubjectDetail> getAllSubjects() throws Throwable;

}
