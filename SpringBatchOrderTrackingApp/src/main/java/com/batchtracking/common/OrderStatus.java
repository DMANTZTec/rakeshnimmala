package com.batchtracking.common;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    private String status;

    private LocalDateTime timeAndDate;

    // Default constructor is needed by JPA
    public OrderStatus() {
    }

    public OrderStatus(int orderid, String status, LocalDateTime timeAndDate) {
        this.orderid = orderid;
        this.status = status;
        this.timeAndDate = timeAndDate;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeAndDate() {
        return timeAndDate;
    }

    public void setTimeAndDate(LocalDateTime timeAndDate) {
        this.timeAndDate = timeAndDate;
    }


   
}
