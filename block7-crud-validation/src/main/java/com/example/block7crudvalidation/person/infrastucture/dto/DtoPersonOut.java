package com.example.block7crudvalidation.person.infrastucture.dto;

import com.example.block7crudvalidation.person.domain.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DtoPersonOut {

    private Integer id_person;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public DtoPersonOut(Person person) {

        setId_person(person.getId_person());
        setUsername(person.getUsername());
        setPassword(person.getPassword());
        setName(person.getName());
        setSurname(person.getSurname());
        setCompany_email(person.getCompany_email());
        setPersonal_email(person.getPersonal_email());
        setCity(person.getCity());
        setActive(person.getActive());
        setCreated_date(person.getCreated_date());
        setImage_url(person.getImage_url());
        setTermination_date(person.getTermination_date());
    }

}
