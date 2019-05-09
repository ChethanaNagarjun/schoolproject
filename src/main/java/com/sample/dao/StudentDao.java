package com.sample.dao;

import java.util.List;
import java.util.UUID;

import com.sample.model.Student;

public interface StudentDao {
	public UUID save(Student student) throws Throwable;

	public Student getById(UUID id) throws Throwable;

	public Student getByFirstName(String firstName) throws Throwable;

	public Student getByLastName(String lastName) throws Throwable;

	public Student getByGender(String gender) throws Throwable;

	public Student getByDateOfBirth(Integer dateOfBirth) throws Throwable;

	public Student getByAge(Integer age) throws Throwable;

	public Student getByCity(String city) throws Throwable;

	public Student getByState(String state) throws Throwable;

	public Student getByZipCode(Integer zipCode) throws Throwable;

	public Student getByPhoneNo(Integer phoneNo) throws Throwable;

	public Student getByAddmissionYear(Integer addmissionYear) throws Throwable;

	public void delete(Student student) throws Throwable;

	public void update(Student student) throws Throwable;

	public List<Student> getAll() throws Throwable;

	public Integer getMaximumRollNo(Integer classId) throws Throwable;

}
