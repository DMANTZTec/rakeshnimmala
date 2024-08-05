package com.batchtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchKafkaTrackingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchKafkaTrackingAppApplication.class, args);
	}

}
