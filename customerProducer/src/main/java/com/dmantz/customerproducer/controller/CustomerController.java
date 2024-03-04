package com.dmantz.customerproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.customerproducer.common.Customer;
import com.dmantz.customerproducer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> customerProducer(@RequestBody Customer customer){
		
		customerService.customerData(customer);
		
		System.out.println(customer.toString());
		
		return new ResponseEntity<>("customer updated",HttpStatus.OK);
		
	}

}
