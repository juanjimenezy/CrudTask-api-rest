package com.indra.crudtask.app.exceptions;

@SuppressWarnings("serial")
public class DuracionInvalidaException extends RuntimeException {

	public DuracionInvalidaException() {
		super();
	}

	public DuracionInvalidaException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuracionInvalidaException(String message) {
		super(message);
	}
}
