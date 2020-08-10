package com.example.indusnetprj.chayaprakashani.exception;

import java.util.Date;

public class ErrorDetails {

	private int status;
	private Date timeStamp;
	private String message;
	private String details;
	
	

	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public ErrorDetails(int status, Date timeStamp, String message, String details) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}


	
	
}
