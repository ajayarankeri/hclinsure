package com.hcl.hclinsure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PolicyNotAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8932183409853887058L;
	
	public PolicyNotAvailableException(String message) {
		super(message);
	}
}
