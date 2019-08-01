package com.hcl.hclinsure.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotCorrectInformationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5964203465478708479L;

	public NotCorrectInformationException(String message) {
		super(message);
	}
}

