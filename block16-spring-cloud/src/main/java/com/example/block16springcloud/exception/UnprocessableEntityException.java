package com.example.block16springcloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException{
    public UnprocessableEntityException(String message) {

        super(message);
        System.out.println("Error: " + message);
    }
}
