package com.bookstore.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3733554262722503550L;
	public ResourceNotFoundException(String message) {
		super(message);
	}


}
