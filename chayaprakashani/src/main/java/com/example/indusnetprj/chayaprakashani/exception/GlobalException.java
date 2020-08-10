package com.example.indusnetprj.chayaprakashani.exception;

import java.util.Date;

import javax.persistence.NonUniqueResultException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<ErrorDetails> handleNonUniqueException(NonUniqueResultException exc,WebRequest req)
	{
		ErrorDetails errordetails =
		new ErrorDetails(HttpStatus.BAD_REQUEST.value(), new Date(), "Email must be unique", req.getDescription(false));
		
		return new ResponseEntity<>(errordetails,HttpStatus.BAD_REQUEST);
	}
	//custom validation error
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> customeValidationException(MethodArgumentNotValidException ex)
	{
		ErrorDetails errordetails =
		new ErrorDetails(HttpStatus.BAD_REQUEST.value(),new Date(),"Validation error",
				ex.getBindingResult().getFieldError().getDefaultMessage());
		
		
		return new ResponseEntity<>(errordetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException
	(ResourceNotFoundException exception,WebRequest request)
	{
		ErrorDetails errordetails =
		new ErrorDetails(HttpStatus.NOT_FOUND.value(),new Date(),exception.getMessage(),
				 request.getDescription(false));
		
		
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateEntryException.class)
	public ResponseEntity<ErrorDetails> handleduplicateEntryException
	(DuplicateEntryException exception,WebRequest request)
	{
		ErrorDetails errordetails =
		new ErrorDetails(HttpStatus.CONFLICT.value(),new Date(),exception.getMessage(),
				 request.getDescription(false));
		
		
		return new ResponseEntity<>(errordetails,HttpStatus.CONFLICT);
	}
}
