package com.example.block7crudvalidation.exception;

import com.example.block7crudvalidation.CustomError;

import java.util.Calendar;

public class UnprocessableEntityException extends Exception{

    public CustomError UnprocessableEntityException() {

        CustomError customError = new CustomError(Calendar.getInstance().getTime(), 422, "El registro solicitado no existe");
        return customError;
    }
}
