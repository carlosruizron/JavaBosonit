package com.example.block7crudvalidation.teacher.infrastucture.dto;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import lombok.Data;

import java.util.Date;

@Data
public class DtoTeacherOut {

    private String comments;
    private String branch;

    public DtoTeacherOut(Teacher teacher) {

        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }

}
