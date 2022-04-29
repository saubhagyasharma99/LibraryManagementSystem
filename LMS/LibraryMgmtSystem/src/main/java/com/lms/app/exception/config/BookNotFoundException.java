package com.lms.app.exception.config;

public class BookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public BookNotFoundException(Long id) {
		super("Book with id:"+id+" not found");
		
	}


	public BookNotFoundException(String field) {
		super("Book not found for "+field);
	}

	
	

}
