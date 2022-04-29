package com.lms.app.exception.config;

public class BorrowNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BorrowNotFoundException() {
		super();
		
	}

	public BorrowNotFoundException(long id) {
		super("Borrow record not found for given id" + id);
	}
	
	

}
