package com.programmer.community.user.exception;

public class DataAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -654252267745575174L;

	public DataAlreadyExistsException(String message) {
		super(message);
	}

}
