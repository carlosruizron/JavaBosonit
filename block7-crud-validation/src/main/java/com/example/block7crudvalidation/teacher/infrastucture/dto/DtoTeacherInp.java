package com.example.block7crudvalidation.teacher.infrastucture.dto;

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

    @Override
    public String toString() {
        return "DtoTeacherInp{" +
                "id_teacher=" + id_teacher +
                ", id_person=" + id_person +
                ", comments='" + comments + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}
