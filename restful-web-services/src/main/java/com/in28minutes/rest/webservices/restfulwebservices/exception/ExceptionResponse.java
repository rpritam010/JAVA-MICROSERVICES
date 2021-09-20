/**
 * 
 */
package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

/**
 * @author PRITAM RAJ
 *
 */
public class ExceptionResponse {
	
	//timestamp
	//message
	//detail

	private String details;
	
	private String message;
	
	private Date timestamp;

	public ExceptionResponse(String details, String message, Date timestamp) {
		super();
		this.details = details;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
