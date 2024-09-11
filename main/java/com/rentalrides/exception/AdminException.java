package com.rentalrides.exception;


	public class AdminException extends Exception {

	    // Constructor with a message
	    public AdminException(String message) {
	        super(message);
	    }

	    // Constructor with a message and cause
	    public AdminException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    // Constructor with cause
	    public AdminException(Throwable cause) {
	        super(cause);
	    }
	}



