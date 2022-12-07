package com.example.block7crudvalidation.subject.domain;

import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.subject.infrastucture.dto.DtoSubjectInp;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Subject {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_subject;

    @ManyToOne
    @JoinColumn(name = "id_student")
    Student student = new Student();

    @ManyToOne
    @JoinColumn(name= "id_teacher")
    Teacher teacher = new Teacher();

    @Column
    String subject;

    @Column
    String comments;

    @Column
    Date initial_date;

    @Column
    Date finish_date;

    public Subject(DtoSubjectInp dtoSubjectInp) {

        setComments(dtoSubjectInp.getComments());
        if(dtoSubjectInp.getInitial_date() != null) {
            setInitial_date(dtoSubjectInp.getInitial_date());
        }
        setSubject(dtoSubjectInp.getSubject());
        setFinish_date(dtoSubjectInp.getFinish_date());
        student.setId_student(dtoSubjectInp.getId_student());
        teacher.setId_teacher(dtoSubjectInp.getId_teacher());
    }

    public void update(@NotNull DtoSubjectInp dtoSubjectInp) {

        setSubject(dtoSubjectInp.getSubject());
        setComments(dtoSubjectInp.getComments());
        if(dtoSubjectInp.getInitial_date() != null) {
            setInitial_date(dtoSubjectInp.getInitial_date());
        }
        setFinish_date(dtoSubjectInp.getFinish_date());
    }


}
