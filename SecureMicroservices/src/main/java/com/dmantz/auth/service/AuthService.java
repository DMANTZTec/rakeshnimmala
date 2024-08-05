package com.dmantz.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dmantz.auth.entity.Users;
import com.dmantz.auth.repository.UserRepo;

@Service
public class AuthService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtService jwtService;

	public String addUser(Users users) {

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		userRepo.save(users);
		return "User Registerd Successfully";

	}

	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
