package com.thymeleaf.common;

public class Student {
	
	private String firstname;
	private String lastname;
	private String role;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Student( String firstname, String lastname, String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}
	@Override
	public String toString() {
		return "Student [ firstname=" + firstname + ", lastname=" + lastname + ", role=" + role + "]";
	}
	
	

}
