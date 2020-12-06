package com.meritamerica.week11.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class ExceedsCombinedLimitException extends Exception {

	public ExceedsCombinedLimitException(String msg) {
		super(msg);
	}

}