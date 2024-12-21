package com.employee.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exceptions.AgeException;
import com.employee.exceptions.NameException;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(AgeException.class)
public ResponseEntity<Object> ageexc(AgeException ae){
	return new ResponseEntity<>("value not found", HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(NameException.class)
public ResponseEntity<Object> name(NameException ne){
	return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
}
@ExceptionHandler(Exception.class)
public ResponseEntity<Object> exc(Exception e){
	return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
}
}
