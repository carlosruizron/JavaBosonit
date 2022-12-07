package com.example.block7crudvalidation.student.infrastucture.dto;

import com.example.block7crudvalidation.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoStudentOut {

    private Integer id_student;
    private int num_hours_week;
    private String comments;
    private String branch;

    public DtoStudentOut(@NotNull Student student) {

        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());

    }

}
