package com.createUser.user.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AllExceptionHandler {
	
	 @ExceptionHandler(Exception.class)
		public final ResponseEntity<Object>  handleAllException(Exception ex,WebRequest request)
		{
			ApiException api= new ApiException(
					ex.getMessage(),
					ex,
					HttpStatus.BAD_REQUEST,
					ZonedDateTime.now(ZoneId.of("Z"))
					);
			return new ResponseEntity<>(api,HttpStatus.BAD_REQUEST);
		}
	
	 @ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object>  handleUserNotFoundException(UserNotFoundException ex,WebRequest request)
	{
		ApiException api= new ApiException(
				ex.getMessage(),
				ex,
				HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z"))
				);
		return new ResponseEntity<>(api,HttpStatus.BAD_REQUEST);
	}

}
