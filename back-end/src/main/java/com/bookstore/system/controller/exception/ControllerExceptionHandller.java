package com.bookstore.system.controller.exception;

import com.bookstore.system.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class ControllerExceptionHandller {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StanderError> ObjectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        StanderError standerError = new StanderError(HttpStatus.NOT_FOUND.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standerError);
    }
}
