package com.dmantz.taskManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class AccesDeclain  extends RuntimeException{
	private String message;
	public AccesDeclain(String message) {
		super(message);
		this.message=message;
	}

}
