package com.dmantz.rediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.rediscache.common.Student;
import com.dmantz.rediscache.dto.StudentDTO;
import com.dmantz.rediscache.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/api/savestudents")
	public String saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
		
	}
	@GetMapping("/api/getall")
	public List<Student> getAllStudent( ) {
		return service.getAllStudent();
		
	}
	@GetMapping("/api/getbyid/{id}")
	public StudentDTO getByIdStudent(@PathVariable int id ) {
		return service.getStudentById(id);
		
	}
	@DeleteMapping("/api/deletebyid/{id}")
	public String deleteByIdStudent(@PathVariable int id ) {
		return service.deleteStudentById(id);
		
	}
	

}
