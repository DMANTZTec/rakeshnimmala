package com.dmantz.taskManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
	private String messeage;
	public UserNotFound(String messeage) {
		super(messeage);
		this.messeage=messeage;
	}

}
