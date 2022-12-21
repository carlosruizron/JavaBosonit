package com.example.block13criteriabuilder.teacher.infrastucture.dto;

import com.example.block13criteriabuilder.teacher.domain.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoTeacherOut {

    private Integer id_teacher;
    private Integer id_person;
    private String comments;
    private String branch;

    public DtoTeacherOut(Teacher teacher) {

        setId_teacher(teacher.getId_teacher());
//        System.out.println(teacher.getId_teacher());
        setId_person(teacher.getPerson().getId_person());
        System.out.println(teacher.getPerson().getId_person());
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());
    }

}
