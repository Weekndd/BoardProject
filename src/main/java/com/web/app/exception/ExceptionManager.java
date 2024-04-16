package com.web.app.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> DataIntegrityViolationExceptionHandler(DataIntegrityViolationException e){
		log.error("DataIntegrityViolationException occurred: {}", e.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(e.getMessage());
	}
}
