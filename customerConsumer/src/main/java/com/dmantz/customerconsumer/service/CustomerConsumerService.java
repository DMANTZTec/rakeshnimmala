package com.dmantz.customerconsumer.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dmantz.customerconsumer.common.Customer;

@Service
public class CustomerConsumerService {
	
	
	Logger log=LoggerFactory.getLogger(CustomerConsumerService.class);
	
	@KafkaListener(topics = "customerTopic",groupId = "CustomerGroup")
	public void consumeCustomer(List<Customer> customer) {
		log.info(customer.toString());
		
		
	}
	

}
