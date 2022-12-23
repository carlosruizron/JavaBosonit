package com.example.block13criteriabuilder.teacher.domain;

import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.person.domain.Person;
import com.example.block13criteriabuilder.teacher.infrastucture.dto.DtoTeacherInp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Teacher {


    @Id
    @GeneratedValue
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
        }else {

        }
        person.setIdPerson(dtoTeacherInp.getId_person());
    }

    public void update(@NotNull DtoTeacherInp dtoTeacherInp) {

        setComments(dtoTeacherInp.getComments());
        if(dtoTeacherInp.getBranch() != null) {
            setBranch(dtoTeacherInp.getBranch());
        }
    }


}
