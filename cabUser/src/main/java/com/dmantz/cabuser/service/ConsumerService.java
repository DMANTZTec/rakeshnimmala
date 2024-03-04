package com.dmantz.cabuser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	
	Logger log=LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics = "cabLocation",groupId = "cabLocation-Group")
	public void consume(String message) {
		
		//log.info("consumer consume the messages {}"+message);
		System.out.println(message);
	}

}
