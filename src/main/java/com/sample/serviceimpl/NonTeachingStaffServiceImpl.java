package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.NonTeachingStaffDao;
import com.sample.model.Activity;
import com.sample.model.NonTeachingStaff;
import com.sample.modelmapper.NonTeachingStaffDetail;
import com.sample.service.NonTeachingStaffService;

@Service
@Transactional
public class NonTeachingStaffServiceImpl implements NonTeachingStaffService {

	@Autowired
	private NonTeachingStaffDao nonTeachingStaffDao;

	@Override
	public UUID save(NonTeachingStaffDetail nonTeachingStaffDetail) throws Throwable {
		UUID id = null;
		try {
			id = nonTeachingStaffDao.save(parseNonTeachingStaffDetailToNonTeachingStaff(nonTeachingStaffDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;
	}

	private NonTeachingStaff parseNonTeachingStaffDetailToNonTeachingStaff(
			NonTeachingStaffDetail nonTeachingStaffDetail) {
		NonTeachingStaff nonTeachingStaff = new NonTeachingStaff();
		if (nonTeachingStaffDetail.getId() != null) {
			nonTeachingStaff.setId(nonTeachingStaffDetail.getId());
		}
		if (nonTeachingStaffDetail.getName() != null) {
			nonTeachingStaff.setName(nonTeachingStaffDetail.getName());
		}
		if (nonTeachingStaffDetail.getYearOfJoin() != null) {
			nonTeachingStaff.setYearOfJoin(nonTeachingStaffDetail.getYearOfJoin());
		}
		if (nonTeachingStaffDetail.getEmailId() != null) {
			nonTeachingStaff.setEmailId(nonTeachingStaffDetail.getEmailId());
		}
		if (nonTeachingStaffDetail.getPhoneNo() != null) {
			nonTeachingStaff.setPhoneNo(nonTeachingStaffDetail.getPhoneNo());
		}
		if (nonTeachingStaffDetail.getSalary() != null) {
			nonTeachingStaff.setSalary(nonTeachingStaffDetail.getSalary());
		}
		if (nonTeachingStaffDetail.getActivityId() != null) {
			Activity activity = new Activity(UUID.fromString(nonTeachingStaffDetail.getActivityId()));
			nonTeachingStaff.setFkeyActivityId(activity);
			
		}
		return nonTeachingStaff;
	}

	private NonTeachingStaffDetail parseNonTeachingStaffToNonTeachingStaffDetail(NonTeachingStaff nonTeachingStaff) {
		NonTeachingStaffDetail nonTeachingStaffDetail = new NonTeachingStaffDetail();
		if (nonTeachingStaff.getId() != null) {
			nonTeachingStaffDetail.setId(nonTeachingStaff.getId());
		}
		if (nonTeachingStaff.getName() != null) {
			nonTeachingStaffDetail.setName(nonTeachingStaff.getName());
		}
		if (nonTeachingStaff.getYearOfJoin() != null) {
			nonTeachingStaffDetail.setYearOfJoin(nonTeachingStaff.getYearOfJoin());
		}
		if (nonTeachingStaff.getEmailId() != null) {
			nonTeachingStaffDetail.setEmailId(nonTeachingStaff.getEmailId());
		}
		if (nonTeachingStaff.getPhoneNo() != null) {
			nonTeachingStaffDetail.setPhoneNo(nonTeachingStaff.getPhoneNo());
		}
		if (nonTeachingStaff.getSalary() != null) {
			nonTeachingStaffDetail.setSalary(nonTeachingStaff.getSalary());
		}
		if (nonTeachingStaff.getFkeyActivityId() != null) {
			nonTeachingStaffDetail.setActivity(nonTeachingStaff.getFkeyActivityId());
			
		}
		return nonTeachingStaffDetail;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		NonTeachingStaff nonteachingstaff = nonTeachingStaffDao.getById(id);
		 nonTeachingStaffDao.delete(nonteachingstaff);

	}

	@Override
	public void update(UUID id,String emailId,String name) throws Throwable {
		NonTeachingStaff nonteachingstaff = nonTeachingStaffDao.getById(id);
		nonteachingstaff.setEmailId(emailId);
		nonteachingstaff.setName(name);
		nonTeachingStaffDao.update(nonteachingstaff);

	}

	@Override
	public List<NonTeachingStaffDetail> getAllNonTeachingStaffs() throws Throwable {
		List<NonTeachingStaff> nonTeachingStaffList = nonTeachingStaffDao.getAll();
		List<NonTeachingStaffDetail> nonTeachingStaffDetailList = new ArrayList<NonTeachingStaffDetail>();

		for (NonTeachingStaff nonTeachingStaff : nonTeachingStaffList) {
			nonTeachingStaffDetailList.add(parseNonTeachingStaffToNonTeachingStaffDetail(nonTeachingStaff));
		}
		return nonTeachingStaffDetailList;
	}

}
