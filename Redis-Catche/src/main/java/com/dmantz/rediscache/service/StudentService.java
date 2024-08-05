package com.dmantz.rediscache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmantz.rediscache.common.Student;
import com.dmantz.rediscache.dto.StudentDTO;
import com.dmantz.rediscache.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@CachePut(value = "student")
	public String saveStudent(Student student) {

		studentRepo.save(student);
		return "successfully saved";

	}

	@Cacheable(value = "student")
	public List<Student> getAllStudent() {

		List<Student> s = studentRepo.findAll();
		return s;
	}

	 @Cacheable(value = "student", key = "#id")
	    @Transactional(readOnly = true)
	    public StudentDTO getStudentById(int id) {
	        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	        return convertToDto(student);
	    }

	@Caching(evict = { @CacheEvict(value = "student", allEntries = true), @CacheEvict(value = "student", key = "#id") })
	public String deleteStudentById(int id) {

		studentRepo.deleteById(id);
		return "Deleted Succsessfully";

	}
	 private StudentDTO convertToDto(Student student) {
	        StudentDTO dto = new StudentDTO();
	        dto.setId(student.getId());
	        dto.setName(student.getName());
	        dto.setEmail(student.getEmail());
	        return dto;
	    }

}
