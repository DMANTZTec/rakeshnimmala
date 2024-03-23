package com.springsecurity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsecurity.model.Employee;
import com.springsecurity.repository.EmployeeRepo;

@Configuration
public class EmployeeUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> employee=employeeRepo.findByEmail(username);
		
		return employee.map(EmployeeInfoDetails::new).orElseThrow(()-> new UsernameNotFoundException("User email not exist"));
	}

}
