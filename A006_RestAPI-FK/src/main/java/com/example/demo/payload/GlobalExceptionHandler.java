package com.example.demo.payload;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIErr> ResourceNotFoundExceptionHandler(ResourceNotFoundException e)
	{
			APIErr err = new APIErr();
			err.setSuccess(false);
			err.setMessage(e.getMessage());
			
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e)
	{
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach((err)->{
	
			String field = err.getField();
			String message = err.getDefaultMessage();
			errors.put(field, message);
		});
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
