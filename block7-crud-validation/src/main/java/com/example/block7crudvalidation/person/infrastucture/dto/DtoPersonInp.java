package com.example.block7crudvalidation.person.infrastucture.dto;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DtoPersonInp implements Serializable {

     Integer id_person;

     String username;
     String password;
     String name;
     String surname;
     String company_email;
     String personal_email;
     String city;
     Boolean active;
     Date created_date;
     String image_url;
     Date termination_date;
}
