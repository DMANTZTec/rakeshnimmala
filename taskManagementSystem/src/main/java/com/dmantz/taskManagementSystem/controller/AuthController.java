package com.dmantz.taskManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.taskManagementSystem.payload.UserDto;
import com.dmantz.taskManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	private UserService userService;
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUder(@RequestBody UserDto userDto) {
	return new	ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
		
	}

}
