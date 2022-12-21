package com.example.block13criteriabuilder.subject.infrastucture.dto;

import com.example.block13criteriabuilder.subject.domain.Subject;
import lombok.Data;

import java.util.Date;

@Data
public class DtoSubjectOut {

    private Integer id_subject;
    private Integer id_student;
    private Integer id_teacher;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public DtoSubjectOut(Subject subject) {

        setId_subject(subject.getId_subject());;
        setId_student(subject.getStudent().getId_student());
        setId_teacher(subject.getTeacher().getId_teacher());
        setComments(subject.getComments());
        setInitial_date(subject.getInitial_date());
        setFinish_date(subject.getFinish_date());

    }

}
