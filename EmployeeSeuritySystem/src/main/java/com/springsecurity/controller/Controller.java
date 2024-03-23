package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.Employee;
import com.springsecurity.repository.EmployeeRepo;
import com.springsecurity.repository.TaskRepo;

@RestController
public class Controller {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private TaskRepo taskRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/home")
	public String homePage() {
		return "This is home page of Employee Security Management Syaytem";
	}

	@PostMapping("/employee/register")
	public ResponseEntity<Object> registerEmployee(@RequestBody Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee result = employeeRepo.save(employee);
		if (result.getId() > 0) {
			return ResponseEntity.ok("Employee Registerd Sucssesfilly");
		}
		return ResponseEntity.status(404).body("Error : Employee Registration failed");
	}

	@GetMapping("/task/all")
	public ResponseEntity<Object> getAllTasks() {
		return ResponseEntity.ok(taskRepo.findAll());
	}

	@GetMapping("/employee/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Object> getAllEmployees() {
		return ResponseEntity.ok(employeeRepo.findAll());
	}
	
	@GetMapping("/employee/single")
	@PreAuthorize("hasAuthority('ADMIN')or hasAuthority('USER')")
	public ResponseEntity<Object> getMyDetails(){
		return ResponseEntity.ok(employeeRepo.findByEmail(getLoggedInUserDetails().getUsername()));
	}

	public  UserDetails getLoggedInUserDetails() {
		
		org.springframework.security.core.Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication!=null && authentication.getPrincipal() instanceof UserDetails) {
			return (UserDetails) authentication.getPrincipal();	
			}
		return null;
	}
}
