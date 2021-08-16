package com.jhonatan.agenda.exceptions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException {

	private Class<?> resource;
	private Long resourceId;

	private static final long serialVersionUID = 4370342787647984970L;

	public <E> ResourceNotFoundExeption(Long resourceId, Class<?> resource) {
		super();
		this.resource = resource;
		this.resourceId = resourceId;
	}

	public Class<?> getResource() {
		return resource;
	}

	public Long getResourceId() {
		return resourceId;
	}


	
}
