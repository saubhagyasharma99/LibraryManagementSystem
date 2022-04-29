package com.lms.app.exception.config;

public class AuthorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AuthorNotFoundException() {
		super();
	}
	
	public AuthorNotFoundException(Long id) {
		super("Author with id: "+id +" not found!");
	}

}
