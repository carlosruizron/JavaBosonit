package com.example.block7crud.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
