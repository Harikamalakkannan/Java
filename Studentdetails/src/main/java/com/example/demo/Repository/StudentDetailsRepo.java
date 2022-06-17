package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.StudentDetails;

@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentDetails,Integer>{

}
