package com.apigatway.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(DataNotFoundException.class)
    public @ResponseBody  ResponseEntity<ErrorInfo> DataNotFoundException(DataNotFoundException e) {
            return new ResponseEntity<>(new ErrorInfo(LocalDateTime.now(), e.getMessage()),HttpStatus.NOT_FOUND);
    } 

    @ExceptionHandler(DuplicateException.class)
    public @ResponseBody  ResponseEntity<ErrorInfo> DuplicateException(DuplicateException e) {
          return new ResponseEntity<>(new ErrorInfo(LocalDateTime.now(), e.getMessage()),HttpStatus.NOT_ACCEPTABLE);
    }
    
}