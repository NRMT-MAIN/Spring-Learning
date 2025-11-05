package com.example.demo.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.ErrorDetails;
import com.example.demo.error.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristNotFoundException tnf) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), tnf.getMessage(), "Resource not found", 404) ; 
		return new ResponseEntity<ErrorDetails>(errorDetails , HttpStatus.NOT_FOUND) ; 
	}
}
