package com.example.block16springcloud2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String errorMessage) {

        System.out.println("Error: " + errorMessage);
        postmanMessage(errorMessage);
    }

    public String postmanMessage(String name) {
        return name;
    }
}
