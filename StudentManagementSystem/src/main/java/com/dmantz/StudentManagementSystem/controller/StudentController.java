package com.dmantz.StudentManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.StudentManagementSystem.entity.Student;
import com.dmantz.StudentManagementSystem.repository.StudentRepo;

@RestController
public class StudentController {
	@Autowired
	StudentRepo studentRepo;
	@PostMapping("/api/students")
	public Student saveStudent(@RequestBody Student student) {
		
		return studentRepo.save(student);
		
	}
	
	@GetMapping("/api/students")
	public List< Student> getAllStudents(Student student) {
		
		return studentRepo.findAll();
		
	}
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudentBuId(@PathVariable int id) {
		Optional<Student> student=studentRepo.findById(id);
		if(student.isPresent()) {
			return new ResponseEntity<Student>(student.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
    @PutMapping("/api/students/{id}")
	public ResponseEntity<Student> UpdateStudentById(@PathVariable int id ,@RequestBody Student stud){
    	Optional<Student> student=studentRepo.findById(id);
    	if(student.isPresent()) {
    		student.get().setStudentName(stud.getStudentName());
    		student.get().setStudentAddress(stud.getStudentAddress());
    		student.get().setStudentEmail(stud.getStudentEmail());
    		
    		return new ResponseEntity<Student>(studentRepo.save(student.get()),HttpStatus.OK);
    	}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    	}
		
	}
    @DeleteMapping("/api/students/{id}")
    public void deleteStudent(@PathVariable int id) {
    	Optional<Student> student=studentRepo.findById(id);
    	if(student.isPresent()) {
    		studentRepo.deleteById(id);
    		
    	}
    	
    }
	

}
