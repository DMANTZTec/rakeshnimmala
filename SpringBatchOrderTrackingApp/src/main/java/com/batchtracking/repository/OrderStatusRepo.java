package com.batchtracking.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batchtracking.common.OrderStatus;

@Repository
public interface OrderStatusRepo extends JpaRepository<OrderStatus, Integer> {
}
