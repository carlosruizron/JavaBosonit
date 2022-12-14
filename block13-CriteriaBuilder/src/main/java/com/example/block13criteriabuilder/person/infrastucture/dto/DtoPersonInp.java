package com.example.block13criteriabuilder.person.infrastucture.dto;

import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
public class DtoPersonInp implements Serializable {

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
}
