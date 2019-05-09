package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.SubjectDao;
import com.sample.model.Subject;
import com.sample.modelmapper.SubjectDetail;
import com.sample.service.SubjectService;

@Service
@Transactional

public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	@Override
	public UUID save(SubjectDetail subjectDetail) throws Throwable {
		UUID id = null;
		try {
			id = subjectDao.save(parseSubjectdDetailToSubject(subjectDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;

	}

	private Subject parseSubjectdDetailToSubject(SubjectDetail subjectDetail) {
		Subject subject = new Subject();
		if (subjectDetail.getId() != null) {
			subject.setId(subjectDetail.getId());
		}

		if (subjectDetail.getSubjectName() != null) {
			subject.setSubjectName(subjectDetail.getSubjectName());
		}
		return subject;
	}

	private SubjectDetail parseSubjectToSubjectDetail(Subject subject) {
		SubjectDetail subjectDetail = new SubjectDetail();
		if (subject.getId() != null) {
			subjectDetail.setId(subject.getId());
		}

		if (subject.getSubjectName() != null) {
			subjectDetail.setSubjectName(subject.getSubjectName());
		}
		return subjectDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		Subject subject = subjectDao.getById(id);
		subjectDao.delete(subject);

	}

	@Override
	public void update(UUID id,String subjectName) throws Throwable {
		Subject subject = subjectDao.getById(id);
		subject.setSubjectName(subjectName);
		subjectDao.update(subject);
	}

	@Override
	public List<SubjectDetail> getAllSubjects() throws Throwable {
		List<Subject> subjectList = subjectDao.getAll();
		List<SubjectDetail> subjectDetailList = new ArrayList<SubjectDetail>();

		for (Subject subject : subjectList) {
			subjectDetailList.add(parseSubjectToSubjectDetail(subject));
		}
		return subjectDetailList;
	}

}
