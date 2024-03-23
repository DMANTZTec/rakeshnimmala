package com.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thymeleaf.common.Student;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/hello")
	public String hellowWord(Model model) {

		model.addAttribute("message", "Thymeleaf Demo");
		return "hello";

	}

	@GetMapping("/cssjs")
	public String cssJs() {

		return "css-js";

	}

	@GetMapping("/bootstrap")
	public String bottstrap() {

		return "bootstrap";

	}

	
	@GetMapping("/swich-case")
	public String swichCase(Model model) {
		Student students=new Student("Rakesh", "Nimmala", "ADMIN");
		
		model.addAttribute("students", students);
		return "switch-case";
	}

}
