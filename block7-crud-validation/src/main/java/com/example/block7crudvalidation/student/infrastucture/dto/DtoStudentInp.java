package com.example.block7crudvalidation.student.infrastucture.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DtoStudentInp implements Serializable {

    private Integer id_student;
    private Integer id_person;
    private int num_hours_week;
    private String comments;
    private String branch;
}
