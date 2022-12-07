package com.example.block7crudvalidation.student.domain;

import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentInp;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {


    @Id
    @GeneratedValue
    Integer id_student;

    @OneToOne
    @JoinColumn(name="id_person")
    Person person = new Person();

    @Column
    int num_hours_week;

    @Column
    String comments;

    @Column
    String branch;

    public Student(@NotNull DtoStudentInp dtoStudentInp) {
        setNum_hours_week(dtoStudentInp.getNum_hours_week());
        setComments(dtoStudentInp.getComments());
        setBranch(dtoStudentInp.getBranch());
        person.setId_person(dtoStudentInp.getId_person());
    }

    public void update(@NotNull DtoStudentInp dtoStudentInp) {
        setNum_hours_week(dtoStudentInp.getNum_hours_week());
        setComments(dtoStudentInp.getComments());
        setBranch(dtoStudentInp.getBranch());
    }


}
