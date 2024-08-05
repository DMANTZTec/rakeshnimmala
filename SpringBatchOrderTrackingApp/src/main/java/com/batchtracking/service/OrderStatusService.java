package com.batchtracking.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusService {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job updateOrderStatusJob;

	@Scheduled(fixedRate = 60000)
	public String updateOrderStatus() throws Exception {
		JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(updateOrderStatusJob, jobParameters);
		return "Batch job started to update order statuses.";
	}
}
