package com.example.block7crudvalidation;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DtoPerson implements Serializable {

    private int id_person;
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

//    public DtoPerson getPersonInfo(Person person) {
//
//        this.setUsername(person.getUsername());
//        this.setPassword(person.getPassword());
//        this.setName(person.getName());
//        this.setSurname(person.getSurname());
//        this.setCompany_email(person.getCompany_email());
//        this.setPersonal_email(person.getPersonal_email());
//        this.setCity(person.getCity());
//        this.setActive(person.getActive());
//        this.setCreated_date(person.getCreated_date());
//        this.setImage_url(person.getImage_url());
//        this.setTermination_date(person.getTermination_date());
//        return null;
//    }
}
