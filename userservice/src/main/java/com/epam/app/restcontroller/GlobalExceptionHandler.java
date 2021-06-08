package com.epam.app.restcontroller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.epam.app.customexception.UserNotFoundException;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponseTemplate> noBookFoundExceptionHandler(UserNotFoundException e){
		ErrorResponseTemplate error = new ErrorResponseTemplate(e.getMessage(), "You have given wrong user id");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorResponseTemplate> emptyResultDataAccessExceptionHandler(EmptyResultDataAccessException e){
		ErrorResponseTemplate error = new ErrorResponseTemplate("No user with this id", "You have given wrong user id");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
