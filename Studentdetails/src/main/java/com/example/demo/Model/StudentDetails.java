package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student_details")
public class StudentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="studnet_id")
	private int studnet_id;
	
	@Column(name="student_name")
	private String student_name; 
	
	@Column(name="student_age")
	private int student_age;
	
	@Column(name="student_phonenumber")
	private int student_phonenumber;
	
	@Column(name="student_emailid")
	private String student_emailid;
	
	@Column(name="gender")
	private String gender;
	
	
	public int getStudent_id() {
		return getStudent_id();
	}
	public void setStudent_id(int student_id) {
		this.studnet_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getStudent_age() {
		return student_age;
	}
	public void setStudent_age(Integer student_age) {
		this.student_age = student_age;
	}
	public Integer getStudent_phonenumber() {
		return student_phonenumber;
	}
	public void setStudent_phonenumber(Integer student_phonenumber) {
		this.student_phonenumber = student_phonenumber;
	}
	public String getStudent_emailid() {
		return student_emailid;
	}
	public void setStudent_emailid(String student_emailid) {
		this.student_emailid = student_emailid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
