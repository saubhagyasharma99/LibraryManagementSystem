package com.lms.app.exception.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BorrowNotFoundAdvice {

	
	@ResponseBody
	@ExceptionHandler(BorrowNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String borrowNotFoundHandler(BorrowNotFoundException ex) {
		return ex.getMessage();
	}
	
	
}
