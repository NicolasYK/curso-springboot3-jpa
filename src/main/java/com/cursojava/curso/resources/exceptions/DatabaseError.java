package com.cursojava.curso.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DatabaseError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, 
			pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", 
			timezone = "GMT")
	private Instant timestamp;
	
	private String message;
	private String details;
	
	// Construtor
	public DatabaseError() {}

	public DatabaseError(Instant timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	// Get & Set
	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
