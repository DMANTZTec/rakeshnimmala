package com.springsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.common.Student;

@RestController
public class StudentController {
	private List<Student> studentlist=new ArrayList<>();
	
	@GetMapping("/student")
	public List<Student> students(){
		
		Student student1=new Student();
		
		student1.setId(101);
		student1.setName("rakesh");
		student1.setEmail("rakesh@gmail");
		student1.setPassword("1234");
		
Student student11=new Student();
		
		student11.setId(101);
		student11.setName("shiva");
		student11.setEmail("shiva@gmail");
		student11.setPassword("8521");
		
		studentlist.add(student1);
		studentlist.add(student11);
		
		
		return studentlist;
		
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(Student student) {
		studentlist.add(student);
		return student;
		
	}

}
