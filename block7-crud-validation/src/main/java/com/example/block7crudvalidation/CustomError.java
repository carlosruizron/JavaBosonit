package com.example.block7crudvalidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomError {

    private Date timeStamp;
    private int HTTPcode;
    private String message;

}
