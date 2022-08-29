package com.capg.exception;

public class FlightDetailsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FlightDetailsNotFoundException(String message) {
		super(message);
	}

}
