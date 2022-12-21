package com.example.block13criteriabuilder.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class CustomError {

    private Date timeStamp;
    private int httpCode;
    private String message;

}
