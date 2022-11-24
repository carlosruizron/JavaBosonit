package com.example.block7crudvalidation.domain;

import com.example.block7crudvalidation.dto.DtoPersonInp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
@Entity
@Table
public class Person {


    @Id
    @GeneratedValue
    @Column
    int id_person;

    @Column
    String username;

    @Column
    String password;

    @Column
    String name;

    @Column
    String surname;

    @Column
    String company_email;

    @Column
    String personal_email;

    @Column
    String city;

    @Column
    Boolean active;

    @Column
    Date created_date;

    @Column
    String image_url;

    @Column
    Date termination_date;

    public Person(DtoPersonInp dtoPersonInp) throws Exception {
        if((dtoPersonInp.getUsername().length() >= 10) && (dtoPersonInp.getUsername().length() <= 6) && (dtoPersonInp.getUsername() == null)) {
            throw new Exception("El usuario no puede estar nulo");
        } else {
            setUsername(dtoPersonInp.getUsername());
        }
        if (dtoPersonInp.getPassword() == null) {
            throw new Exception("La contraseña no puede ser null");
        } else {
            setPassword(dtoPersonInp.getPassword());
        }
        if (dtoPersonInp.getName() == null) {
            throw new Exception("El nombre no puede ser null");
        } else {
            setName(dtoPersonInp.getName());
        }
        if (dtoPersonInp.getCompany_email() == null) {
            throw new Exception("El email de la empresa no puede ser null");
        } else {
            setCompany_email(dtoPersonInp.getCompany_email());
        }
        if (dtoPersonInp.getPersonal_email() == null) {
            throw new Exception("El email personal no puede ser null");
        } else {
            setPersonal_email(dtoPersonInp.getPersonal_email());
        }
        if (dtoPersonInp.getCity() == null) {
            throw new Exception("La ciudad no puede ser null");
        } else {
            setCity(dtoPersonInp.getCity());
        }
        setSurname(dtoPersonInp.getSurname());
        setActive(dtoPersonInp.getActive());
        setCreated_date(new Date());
        setImage_url(dtoPersonInp.getImage_url());
        setTermination_date(dtoPersonInp.getTermination_date());
        setId_person();
    }


}
