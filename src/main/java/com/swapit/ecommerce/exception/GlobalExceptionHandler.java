package com.swapit.ecommerce.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> validationError(ConstraintViolationException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getConstraintViolations().forEach(error -> {
			errorMap.put(error.getPropertyPath().toString(), error.getMessage());
		});
		return ResponseEntity.ofNullable(errorMap);
	}

	@ExceptionHandler(ProductInvalidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> validationError(ProductInvalidException ex) {
		return ResponseEntity.ofNullable(ex.getExceptionMsg());
	}
}
