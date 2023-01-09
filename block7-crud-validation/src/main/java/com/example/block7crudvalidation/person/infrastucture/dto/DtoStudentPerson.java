package com.example.block7crudvalidation.person.infrastucture.dto;

import com.example.block7crudvalidation.student.domain.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoStudentPerson extends DtoPersonOut{
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

    //Parámetros de Student

    private int id_student;

    private int num_hours_week;

    private String comments;

    private String branch;

    public DtoStudentPerson getStudentPerson(Student student) {
        //Parte de Student
        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());
        //Parte de Persona
        setId_person(student.getPerson().getId_person());
        setUsername(student.getPerson().getUsername());
        setPassword(student.getPerson().getPassword());
        setName(student.getPerson().getName());
        setSurname(student.getPerson().getSurname());
        setCompany_email(student.getPerson().getCompany_email());
        setPersonal_email(student.getPerson().getPersonalEmail());
        setCity(student.getPerson().getCity());
        setActive(student.getPerson().getActive());
        setCreated_date(student.getPerson().getCreated_date());
        setImage_url(student.getPerson().getImage_url());
        setTermination_date(student.getPerson().getTermination_date());
        return null;
    }

    public DtoStudentPerson (Student student) {
        //Parte de Student
        setId_student(student.getId_student());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());
        //Parte de Persona
        setId_person(student.getPerson().getId_person());
        setUsername(student.getPerson().getUsername());
        setPassword(student.getPerson().getPassword());
        setName(student.getPerson().getName());
        setSurname(student.getPerson().getSurname());
        setCompany_email(student.getPerson().getCompany_email());
        setPersonal_email(student.getPerson().getPersonalEmail());
        setCity(student.getPerson().getCity());
        setActive(student.getPerson().getActive());
        setCreated_date(student.getPerson().getCreated_date());
        setImage_url(student.getPerson().getImage_url());
        setTermination_date(student.getPerson().getTermination_date());
    }
}
