package com.jhonatan.agenda.exceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 4370342787647984970L;

	public <E> DataIntegrityException(String message) {
		super(message);
		
	}
}
