package com.dmantz.cabbookingdiver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmantz.cabbookingdiver.service.ProducerService;

@RestController
public class ProducerController {
	
	@Autowired
	public ProducerService producerService;
	
	@PostMapping("/location")
	public ResponseEntity<?> cabLocation() throws InterruptedException {
		
		int range =10;
		while(range>0) {
			producerService.cablocation(Math.random()+" ,"+ Math.random());
			Thread.sleep(1000);
			range--;
		}
		
		
		return new ResponseEntity<String>("Location Updated",HttpStatus.OK);
		
	}

}
