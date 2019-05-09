package com.sample.model;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "student")

public class Student {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Type(type = "pg-uuid")
	@Basic(optional = false)
	@Column(columnDefinition = "BINARY(16)", name = "id")
	private UUID id;
	@Size(max = 20)
	@Column(name = "firstname")
	private String firstName;
	@Size(max = 20)
	@Column(name = " lastname")
	private String lastName;
	@Size(max = 10)
	@Column(name = "gender")
	private String gender;
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	@Column(name = "age")
	private Integer age;
	@Size(max = 100)
	@Column(name = "street_address")
	private String streetAddress;
	@Size(max = 20)
	@Column(name = "city")
	private String city;
	@Size(max = 20)
	@Column(name = "state")
	private String state;
	@Column(name = "zipcode")
	private Integer zipCode;
	@Column(name = "phone_no")
	private Integer phoneNo;
	@Column(name = "addmission_year")
	private Integer addmissionYear;
    @Column(name = "roll_no")
	private Integer rollNo;

	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TeachingStaff fkeyStudentTeachingStaffId;

	@JoinColumn(name = "nonteacher_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private NonTeachingStaff fKeyStudentNonTeachingStaffId;

	@JoinColumn(name = "report_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Report fkeyStudentReportId;

	@JoinColumn(name = "student_standard_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Standard fkeyStudentStandardId;


	public Student() {

	}

	public Student(UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAdress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getAddmissionYear() {
		return addmissionYear;
	}

	public void setAddmissionYear(Integer addmissionYear) {
		this.addmissionYear = addmissionYear;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public TeachingStaff getFkeyStudentTeachingStaffId() {
		return fkeyStudentTeachingStaffId;
	}

	public void setFkeyStudentTeachingStaffId(TeachingStaff fkeyStudentTeachingStaffId) {
		this.fkeyStudentTeachingStaffId = fkeyStudentTeachingStaffId;
	}

	public NonTeachingStaff getfKeyStudentNonTeachingStaffId() {
		return fKeyStudentNonTeachingStaffId;
	}

	public void setfKeyStudentNonTeachingStaffId(NonTeachingStaff fKeyStudentNonTeachingStaffId) {
		this.fKeyStudentNonTeachingStaffId = fKeyStudentNonTeachingStaffId;
	}

	public Report getFkeyStudentReportId() {
		return fkeyStudentReportId;
	}

	public void setFkeyStudentReportId(Report fkeyStudentReportId) {
		this.fkeyStudentReportId = fkeyStudentReportId;
	}

	public Standard getFkeyStudentStandardId() {
		return fkeyStudentStandardId;
	}

	public void setFkeyStudentStandardId(Standard fkeyStudentStandardId) {
		this.fkeyStudentStandardId = fkeyStudentStandardId;
	}

	
	
	
}
