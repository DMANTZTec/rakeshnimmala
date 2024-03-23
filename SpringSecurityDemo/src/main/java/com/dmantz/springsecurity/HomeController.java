package com.dmantz.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "This is Admin Page";
	}

}
