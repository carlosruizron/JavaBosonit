package com.example.block7crudvalidation.person.infrastucture.dto;

import com.example.block7crudvalidation.teacher.domain.Teacher;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoTeacherPerson  extends DtoPersonOut{

    //Parámetros de Person
    private Integer id_person;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private Boolean active;

    private Date created_date;

    private String image_url;

    private Date termination_date;

    //Parámetros de Teacher

    private int id_teacher;

    private String comments;

    private String branch;

    public DtoTeacherPerson getTeacherPerson(Teacher teacher) {

        //Parte de Student
        setId_teacher(teacher.getId_teacher());
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());

        //Parte de Persona
        setId_person(teacher.getPerson().getId_person());
        setUsername(teacher.getPerson().getUsername());
        setPassword(teacher.getPerson().getPassword());
        setName(teacher.getPerson().getName());
        setSurname(teacher.getPerson().getSurname());
        setCompany_email(teacher.getPerson().getCompany_email());
        setPersonal_email(teacher.getPerson().getPersonalEmail());
        setCity(teacher.getPerson().getCity());
        setActive(teacher.getPerson().getActive());
        setCreated_date(teacher.getPerson().getCreated_date());
        setImage_url(teacher.getPerson().getImage_url());
        setTermination_date(teacher.getPerson().getTermination_date());
        return null;
    }

    public DtoTeacherPerson (Teacher teacher) {

        //Parte de Student
        setId_teacher(teacher.getId_teacher());
        setComments(teacher.getComments());
        setBranch(teacher.getBranch());

        //Parte de Persona
        setId_person(teacher.getPerson().getId_person());
        setUsername(teacher.getPerson().getUsername());
        setPassword(teacher.getPerson().getPassword());
        setName(teacher.getPerson().getName());
        setSurname(teacher.getPerson().getSurname());
        setCompany_email(teacher.getPerson().getCompany_email());
        setPersonal_email(teacher.getPerson().getPersonalEmail());
        setCity(teacher.getPerson().getCity());
        setActive(teacher.getPerson().getActive());
        setCreated_date(teacher.getPerson().getCreated_date());
        setImage_url(teacher.getPerson().getImage_url());
        setTermination_date(teacher.getPerson().getTermination_date());
    }
}
