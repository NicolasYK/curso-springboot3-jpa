package com.cursojava.curso.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cursojava.curso.services.exceptions.DatabaseException;
import com.cursojava.curso.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

// A notação faz interceptação dos erros 
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Faz a interceptação do erro relacionado a essa classe
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<DatabaseError> database(DatabaseException e, WebRequest request){
		String genericMessage = "An error occurred while processing your request.";
		DatabaseError err = new DatabaseError(Instant.now(), genericMessage, request.getDescription(false));
		return new ResponseEntity<DatabaseError>(err, HttpStatus.BAD_REQUEST);
	}
	
}
