package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.StudentDetails;
import com.example.demo.Service.StudentDetailsService;


@RestController
@RequestMapping(value ="/Studentdetails")
public class StudentDetailsController {
	@Autowired
     StudentDetailsService studentDetailsService;
	
	@GetMapping(value="/getAllStudentDetails")	
	public StudentDetails getAllStudentDetails (){
		return studentDetailsService.getAllStudentdetails() }


	@PostMapping(value="/createNewStudentDetails")
	public StudentDetails createStudentDetails(@RequestBody StudentDetails newDetails) {
		return studentDetailsService.getAllStudentdetails(newDetails);}
		
		@RequestMapping(method=RequestMethod.PUT,value="/Studentdetails")
		
		public void UpdateUser(@PathVariable Integer id, @RequestBody studentdetails newStudentdetails) {
			Studentdetails.UpdateUser(id, Studentdetails);
		}
		
		@DeleteMapping(value="/deleteOneStudentDetail")
		public String deleteOneProduct(@RequestParam StudentDetail) {
			
			StudentDetailService.deleteStudentDetail(StudentDetail);
			
			return " StudentDetail Deleted Succcessfully";
		}
}

		
	

