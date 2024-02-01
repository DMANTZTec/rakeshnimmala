package com.dmantz.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmantz.StudentManagementSystem.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
