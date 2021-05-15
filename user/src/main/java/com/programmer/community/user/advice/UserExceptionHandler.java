package com.programmer.community.user.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.programmer.community.user.exception.DataAlreadyExistsException;
import com.programmer.community.user.exception.DataNotFoundException;
import com.programmer.community.user.model.Response;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Response> handleDataNotFoundException() {
		return new ResponseEntity<Response>(Response.getNotFound(), HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<Response> handleDataAlreadyExistsException() {
		return new ResponseEntity<Response>(Response.getExists(), HttpStatus.CONFLICT);
	}
}
