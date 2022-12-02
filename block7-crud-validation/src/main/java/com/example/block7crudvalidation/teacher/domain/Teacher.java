package com.example.block7crudvalidation.teacher.domain;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherInp;
import jakarta.persistence.*;
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
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_teacher;

    @OneToOne
    @JoinColumn(name="id_person")
    Person person = new Person();

    @Column
    String comments;

    @Column
    String branch;

    public Teacher(DtoTeacherInp dtoTeacherInp) throws UnprocessableEntityException {

        setComments(dtoTeacherInp.getComments());
        if(dtoTeacherInp.getBranch() != null) {
            setBranch(dtoTeacherInp.getBranch());
        }
        person.setId_person(dtoTeacherInp.getId_person());

    }

    public void update(@NotNull DtoTeacherInp dtoTeacherInp) {

        setComments(dtoTeacherInp.getComments());
        if(dtoTeacherInp.getBranch() != null) {
            setBranch(dtoTeacherInp.getBranch());
        }
        person.setId_person(dtoTeacherInp.getId_person());
    }


}
