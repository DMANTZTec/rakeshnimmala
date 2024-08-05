package com.dmantz.auth.controller;

import com.dmantz.auth.entity.Users;
import com.dmantz.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public String addUser(@RequestBody Users users) {
		return authService.addUser(users);
	}

	@PostMapping("/tokenGeneration")
	public String getToken(@RequestBody Users users) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(users.getName(), users.getPassword()));
		if (authentication.isAuthenticated()) {
			return authService.generateToken(users.getName());
		} else {
			throw new RuntimeException(users.getName() + " Not Found In DataBase");
		}
	}

	@GetMapping("/tokenValidation")
	public String validateToken(@RequestParam("token") String token) {
		authService.validateToken(token);
		return "Token is Valid";
	}
}
