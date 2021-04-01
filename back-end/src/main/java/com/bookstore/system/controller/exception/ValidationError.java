package com.bookstore.system.controller.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationError extends StanderError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String error) {
        super(status, error);
    }

    public ValidationError() {
    }

    //Adicionando erro por erro dentro da lista de ERRORS.
    public void addErrors(String fieldName, String msg){
        this.errors.add(new FieldMessage(fieldName, msg));
    }
}
