package com.dmantz.customerproducer.common;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Customer {
	
	int id;
	String name;
	String email;
	String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", state=" + state + "]";
	}
	

}
