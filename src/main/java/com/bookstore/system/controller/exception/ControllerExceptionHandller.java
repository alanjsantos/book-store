package com.bookstore.system.controller.exception;


import com.bookstore.system.service.exception.DataIntegrityViolationException;
import com.bookstore.system.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StanderError> DataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
        StanderError standerError = new StanderError(HttpStatus.BAD_REQUEST.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standerError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StanderError> validationErros(MethodArgumentNotValidException e, ServletRequest request){
        ValidationError error = new ValidationError (HttpStatus.BAD_REQUEST.value(), "Erro na validação dos campos.");

        for (FieldError x: e.getBindingResult().getFieldErrors()){
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


}
