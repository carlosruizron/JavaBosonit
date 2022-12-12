package com.example.block7crudvalidation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class CustomError {

    private Date timeStamp;
    private int httpCode;
    private String message;

}
