package com.swapit.ecommerce.exception;

public class ProductInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String exceptionMsg;

	public ProductInvalidException(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

}
