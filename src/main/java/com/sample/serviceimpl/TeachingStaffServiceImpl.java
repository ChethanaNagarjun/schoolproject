package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.TeachingStaffDao;
import com.sample.model.Standard;
import com.sample.model.Subject;
import com.sample.model.TeachingStaff;
import com.sample.modelmapper.TeachingStaffDetail;
import com.sample.service.TeachingStaffService;

@Service
@Transactional
public class TeachingStaffServiceImpl implements TeachingStaffService {

	@Autowired
	private TeachingStaffDao teachingStaffDao;

	@Override
	public UUID save(TeachingStaffDetail teachingStaffDetail) throws Throwable {
		UUID id = null;
		try {
			id = teachingStaffDao.save(parseTeachingStaffDetailToTeachingStaff(teachingStaffDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;

	}

	private TeachingStaff parseTeachingStaffDetailToTeachingStaff(TeachingStaffDetail teachingStaffDetail) {
		TeachingStaff teachingStaff = new TeachingStaff();
		if (teachingStaffDetail.getId() != null) {
			teachingStaff.setId(teachingStaffDetail.getId());
		}
		if (teachingStaffDetail.getName() != null) {
			teachingStaff.setName(teachingStaffDetail.getName());
		}
		if (teachingStaffDetail.getYearOfJoin() != null) {
			teachingStaff.setYearOfJoin(teachingStaffDetail.getYearOfJoin());
		}
		if (teachingStaffDetail.getEducationDetails() != null) {
			teachingStaff.setEducationDetails(teachingStaffDetail.getEducationDetails());
		}
		if (teachingStaffDetail.getEmailId() != null) {
			teachingStaff.setEmailId(teachingStaffDetail.getEmailId());
		}
		if (teachingStaffDetail.getPhoneNo() != null) {
			teachingStaff.setPhoneNo(teachingStaffDetail.getPhoneNo());
		}
		if (teachingStaffDetail.getSalary() != null) {
			teachingStaff.setSalary(teachingStaffDetail.getSalary());
		}
		
		if(teachingStaffDetail.getStandardId()!= null) {
			Standard standard = new Standard(UUID.fromString(teachingStaffDetail.getStandardId()));
			teachingStaff.setFkeyTeacherStandardId(standard);
		}
		if(teachingStaffDetail.getSubjectId()!= null) {
			Subject subject = new Subject(UUID.fromString(teachingStaffDetail.getSubjectId()));
			teachingStaff.setFkeyTeacherSubjectId(subject);
			
		}

		return teachingStaff;
	}

	private TeachingStaffDetail parseTeachingStaffToTeachingStaffDetail(TeachingStaff teachingStaff) {
		TeachingStaffDetail teachingStaffDetail = new TeachingStaffDetail();
		if (teachingStaff.getId() != null) {
			teachingStaffDetail.setId(teachingStaff.getId());
		}
		if (teachingStaff.getName() != null) {
			teachingStaffDetail.setName(teachingStaff.getName());
		}
		if (teachingStaff.getYearOfJoin() != null) {
			teachingStaffDetail.setYearOfJoin(teachingStaff.getYearOfJoin());
		}
		if (teachingStaff.getEducationDetails() != null) {
			teachingStaffDetail.setEducationDetails(teachingStaff.getEducationDetails());
		}
		if (teachingStaff.getEmailId() != null) {
			teachingStaffDetail.setEmailId(teachingStaff.getEmailId());
		}
		if (teachingStaff.getPhoneNo() != null) {
			teachingStaffDetail.setPhoneNo(teachingStaff.getPhoneNo());
		}
		if (teachingStaff.getSalary() != null) {
			teachingStaffDetail.setSalary(teachingStaff.getSalary());
		}
		return teachingStaffDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		TeachingStaff teachingstaff = teachingStaffDao.getById(id);
		teachingStaffDao.delete(teachingstaff);

	}

	@Override
	public void update(UUID id,Integer salary) throws Throwable {
        TeachingStaff teachingstaff = teachingStaffDao.getByName("pushpa");
        teachingstaff.setSalary(salary);
		teachingStaffDao.update(teachingstaff);
	}

	@Override
	public List<TeachingStaffDetail> getAllTeachingStaffs() throws Throwable {
		List<TeachingStaff> teachingStaffList = teachingStaffDao.getAll();
		List<TeachingStaffDetail> teachingStaffDetailList = new ArrayList<TeachingStaffDetail>();

		for (TeachingStaff teachingStaff : teachingStaffList) {
			teachingStaffDetailList.add(parseTeachingStaffToTeachingStaffDetail(teachingStaff));
		}
		return teachingStaffDetailList;
	}
}
