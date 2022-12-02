package com.example.block7crudvalidation.student.infrastucture.dto;

import com.example.block7crudvalidation.student.domain.Student;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class DtoStudentOut {

    private Integer id_student;
    private Integer id_person;
    private int num_hours_week;
    private String comments;
    private Integer id_teacher;
    private String branch;

    public DtoStudentOut(@NotNull Student student) {

        setId_student(student.getId_student());
        setId_person(student.getPerson().getId_person());
        setId_student(student.getId_student());
        setId_teacher(student.getTeacher().getId_teacher());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());

    }

}
