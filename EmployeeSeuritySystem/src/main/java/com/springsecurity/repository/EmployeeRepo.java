package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.model.Employee;
import java.util.Optional;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	public Optional<Employee> findByEmail(String email);
	
	

}
