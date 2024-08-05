package com.batchtracking.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.client.RestTemplate;

import com.batchtracking.common.OrderStatus;
import com.batchtracking.repository.OrderStatusRepo;

import java.time.LocalDateTime;
import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Value("${tracktry.api.key}")
	private String tracktryApiKey;

	@Autowired
	private PlatformTransactionManager platformTransactionManager;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	
	private OrderStatusRepo orderStatusRepo;
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private KafkaTemplate<String,OrderStatus> kafkaTemplate;
	
	
	private static final String topic="OrderStatus";

	@Bean
	public Job updateOrderStatusJob() {
		return new JobBuilder("updateOrderStatusJob", jobRepository).incrementer(new RunIdIncrementer())
				.flow(updateOrderStatusStep()).end().build();
	}

	@Bean
	public Step updateOrderStatusStep() {
		return new StepBuilder("updateOrderStatusStep", jobRepository)
				.<OrderStatus, OrderStatus>chunk(10, platformTransactionManager).reader(orderStatusReader())
				.processor(orderStatusProcessor()).writer(orderStatusWriter()).build();
	}

	@Bean
	public RepositoryItemReader<OrderStatus> orderStatusReader() {
		RepositoryItemReader<OrderStatus> reader = new RepositoryItemReader<>();
		reader.setRepository(orderStatusRepo);
		reader.setMethodName("findAll");
		reader.setSort(Collections.singletonMap("orderid", Sort.Direction.ASC));
		return reader;
	}

	@Bean
	public ItemProcessor<OrderStatus, OrderStatus> orderStatusProcessor() {
		return orderStatus -> {
			String trackingInfo = trackShipment("1Z999AA10123456784", "ups", orderStatus.getOrderid());
			orderStatus.setStatus(trackingInfo);
			orderStatus.setTimeAndDate(LocalDateTime.now());
			orderStatusRepo.save(orderStatus);
			return orderStatus;
		};
	}

	@Bean
	public ItemWriter<OrderStatus> orderStatusWriter() {
	    return items -> {
	        for (OrderStatus orderStatus : items) {
	            kafkaTemplate.send(topic, orderStatus);
	        }
	    };
	}

	public String trackShipment(String trackingNumber, String carrierCode, int orderId) {
		String url = "https://api.tracktry.com/v1/trackings/get";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Tracktry-Api-Key", tracktryApiKey);
		headers.set("Content-Type", "application/json");

		String requestJson = String.format("{\"tracking_number\": \"%s\", \"carrier_code\": \"%s\"}", trackingNumber,
				carrierCode);
		HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		return response.getBody();
	}
}
