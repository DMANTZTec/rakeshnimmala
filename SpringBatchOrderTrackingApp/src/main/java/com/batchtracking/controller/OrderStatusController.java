package com.batchtracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batchtracking.service.OrderStatusService;

@RestController
@RequestMapping("/api")
public class OrderStatusController {

	
	@Autowired
   OrderStatusService orderStatusService;

    @PostMapping("/updateOrderStatus")
    public String getOrderStatusFromDeliveryAPI() throws Exception {
		return orderStatusService.updateOrderStatus();
    	
    }
    
}
