package com.example.block13criteriabuilder.teacher.infrastucture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DtoTeacherInp implements Serializable {

    private Integer id_teacher;
    private Integer id_person;
    private String comments;
    private String branch;

}
