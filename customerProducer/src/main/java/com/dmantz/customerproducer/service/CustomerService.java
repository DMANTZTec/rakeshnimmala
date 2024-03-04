package com.dmantz.customerproducer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dmantz.customerproducer.common.Customer;

@Service
public class CustomerService {
	

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	
	private static final String topic="customerTopic";
	
	public void customerData(Customer customer) {
		kafkaTemplate.send(topic, customer);
		
	}

}
