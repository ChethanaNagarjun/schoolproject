package com.sample.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.dao.StudentDao;
import com.sample.model.NonTeachingStaff;
import com.sample.model.Report;
import com.sample.model.Standard;
import com.sample.model.Student;
import com.sample.model.TeachingStaff;
import com.sample.modelmapper.StudentDetail;
import com.sample.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public UUID save(StudentDetail studentDetail) throws Throwable

	{
		UUID id = null;
		try {
			id = studentDao.save(parseStudentDetailTostudent(studentDetail));
		} catch (Throwable throwable) {
			throw new Throwable(throwable.getMessage());
		}
		return id;
	}

	private Student parseStudentDetailTostudent(StudentDetail studentDetail) throws Throwable {
		Student student = new Student();
		if (studentDetail.getId() != null) {
			student.setId(studentDetail.getId());
		}

		if (studentDetail.getFirstName() != null) {
			student.setFirstName(studentDetail.getFirstName());
		}

		if (studentDetail.getLastName() != null) {
			student.setLastName(studentDetail.getLastName());
		}

		if (studentDetail.getGender() != null) {
			student.setGender(studentDetail.getGender());
		}
		if (studentDetail.getDateOfBirth() != null) {
			student.setDateOfBirth(studentDetail.getDateOfBirth());
		}

		if (studentDetail.getAge() != null) {
			student.setAge(studentDetail.getAge());
		}
		if (studentDetail.getCity() != null) {
			student.setCity(studentDetail.getCity());
		}
		if (studentDetail.getState() != null) {
			student.setState(studentDetail.getState());
		}
		if (studentDetail.getZipCode() != null) {
			student.setZipCode(studentDetail.getZipCode());
		}
		if (studentDetail.getPhoneNo() != null) {
			student.setPhoneNo(studentDetail.getPhoneNo());
		}
		if (studentDetail.getAddmissionYear() != null) {
			student.setAddmissionYear(studentDetail.getAddmissionYear());
		}
		
		if(studentDetail.getReportId()!= null) {
			Report report = new Report(UUID.fromString(studentDetail.getReportId()));
			student.setFkeyStudentReportId(report);
		}
		
		if(studentDetail.getNonTeachingStaffId()!= null) {
			NonTeachingStaff nonteachingstaff = new NonTeachingStaff(UUID.fromString(studentDetail.getNonTeachingStaffId()));
			student.setfKeyStudentNonTeachingStaffId(nonteachingstaff);
		}
			
		if(studentDetail.getTeachingStaffId()!= null) {
			TeachingStaff teachingstaff = new TeachingStaff(UUID.fromString(studentDetail.getTeachingStaffId()));
			student.setFkeyStudentTeachingStaffId(teachingstaff);
		}
		
		if(studentDetail.getStandardId()!= null) {
			Standard standard = new Standard(UUID.fromString(studentDetail.getStandardId()));
			student.setFkeyStudentStandardId(standard);
		}
		
		return student;
	}

	private StudentDetail parseStudentToStudentDetail(Student student) throws Throwable {
		StudentDetail studentDetail = new StudentDetail();
		if (student.getId() != null) {
			studentDetail.setId(student.getId());
		}

		if (student.getFirstName() != null) {
			studentDetail.setFirstName(studentDetail.getFirstName());
		}

		if (student.getLastName() != null) {
			studentDetail.setLastName(student.getLastName());
		}

		if (student.getGender() != null) {
			studentDetail.setGender(student.getGender());
		}
		if (student.getDateOfBirth() != null) {
			studentDetail.setDateOfBirth(student.getDateOfBirth());
		}
        if (student.getAge() != null) {
			studentDetail.setAge(student.getAge());
		}
		if (student.getCity() != null) {
			studentDetail.setCity(student.getCity());
		}
		if (student.getState() != null) {
			studentDetail.setState(student.getState());
		}
		if (student.getZipCode() != null) {
			studentDetail.setZipCode(student.getZipCode());
		}
		if (student.getPhoneNo() != null) {
			studentDetail.setPhoneNo(student.getPhoneNo());
		}
		if (student.getAddmissionYear() != null) {
			studentDetail.setAddmissionYear(student.getAddmissionYear());
		}

		return studentDetail;
	}

	@Override
	public List<StudentDetail> getAllStudents() throws Throwable {

		List<Student> studentList = studentDao.getAll();
		List<StudentDetail> studentDetailList = new ArrayList<StudentDetail>();

		for (Student student : studentList) {
			studentDetailList.add(parseStudentToStudentDetail(student));
		}
		return studentDetailList;
	}

	@Override
	public void delete(UUID id) throws Throwable {
		Student student =(studentDao.getById(id));
		studentDao.delete(student);

	}

	@Override
	public void update(UUID id,Integer phoneNo) throws Throwable {
		Student student =(studentDao.getById(id));
		student.setPhoneNo(phoneNo);
		studentDao.update(student);

	}

}
