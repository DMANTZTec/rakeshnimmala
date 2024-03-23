package com.dmantz.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/admin")
	public String homePage() {
		return "@ # $ % % ^M This is home page of spring security";
	}
	
	@RequestMapping("login")
	public String loginPage() {
		return "This is Login page";
	}

}
