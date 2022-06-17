package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Repository.StudentDetails;
import com.example.demo.Repository.StudentDetailsRepo;

@Service

public class StudentDetailsService {
	@Autowired
     StudentDetailsRepo studentDetailsRepo;
	
	public StudentDetailsService getAllStudentDetails {
	
		return studentDetails.findAll();
		
	}
	public <Student> void UpdateStudentdetails(Student Studentdetails) {
		StudentDetailsRepo.save(Studentdetails);	
	}

	public void addStudentdetails(StudentDetails Studentdetails) {
		StudentDetailsRepo.save(Studentdetails);
		}

	public void deleteStudentdetails(Integer id) {
		studentDetailsRepo.deleteById(id);
		
	}

	
		
		
		
	}
	


