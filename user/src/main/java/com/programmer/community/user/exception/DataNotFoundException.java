package com.programmer.community.user.exception;

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7628604018789968089L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
