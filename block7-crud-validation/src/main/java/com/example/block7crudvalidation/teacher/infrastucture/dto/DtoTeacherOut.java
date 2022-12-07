package com.example.block7crudvalidation.teacher.infrastucture.dto;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoTeacherOut {

    private Integer id_teacher;
    private Integer id_person;
    private String comments;
    private String branch;

    public DtoTeacherOut(Teacher teacher) {

        setId_teacher(teacher.getId_teacher());
        setId_person(teacher.getPerson().getId_person());
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }

}
