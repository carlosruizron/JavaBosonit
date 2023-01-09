package com.example.block7crudvalidation.person.domain;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonInp;
import javax.persistence.*;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Person {


    @Id
    @GeneratedValue
    Integer id_person;

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
    String personalEmail;

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

    @Column
    private Boolean admin;

    public Person(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {
        if((dtoPersonInp.getUsername() == null) && (dtoPersonInp.getUsername().length() >= 10) && (dtoPersonInp.getUsername().length() <= 6)) {
            throw new UnprocessableEntityException("El usuario no puede estar nulo");
        } else {
            setUsername(dtoPersonInp.getUsername());
        }
        if (dtoPersonInp.getPassword() == null) {
            throw new UnprocessableEntityException("La contraseña no puede ser null");
        } else {
            setPassword(dtoPersonInp.getPassword());
        }
        if (dtoPersonInp.getName() == null) {
            throw new UnprocessableEntityException("El nombre no puede ser null");
        } else {
            setName(dtoPersonInp.getName());
        }
        if (dtoPersonInp.getCompany_email() == null) {
            throw new UnprocessableEntityException("El email de la empresa no puede ser null");
        } else {
            setCompany_email(dtoPersonInp.getCompany_email());
        }
        if (dtoPersonInp.getPersonalEmail() == null) {
            throw new UnprocessableEntityException("El email personal no puede ser null");
        } else {
            setPersonalEmail(dtoPersonInp.getPersonalEmail());
        }
        if (dtoPersonInp.getCity() == null) {
            throw new UnprocessableEntityException("La ciudad no puede ser null");
        } else {
            setCity(dtoPersonInp.getCity());
        }
        setSurname(dtoPersonInp.getSurname());
        setActive(dtoPersonInp.getActive());
        setCreated_date(new Date());
        setImage_url(dtoPersonInp.getImage_url());
        setTermination_date(dtoPersonInp.getTermination_date());
        if(dtoPersonInp.getAdmin() == null) {
            setAdmin(false);
        }
    }

    public void update(@NotNull DtoPersonInp dtoPersonInp) {
        if (dtoPersonInp.getUsername() != null
                && dtoPersonInp.getUsername().length() >= 6
                && dtoPersonInp.getUsername().length() <= 10) {
            setUsername(dtoPersonInp.getUsername());
        }
        if (dtoPersonInp.getName() != null) {
            setName(dtoPersonInp.getName());
        }
        if (dtoPersonInp.getSurname() != null) {
            setSurname(dtoPersonInp.getSurname());
        }
        if (dtoPersonInp.getPassword() != null) {
            setPassword(dtoPersonInp.getPassword());
        }
        if (dtoPersonInp.getCompany_email() != null) {
            setCompany_email(dtoPersonInp.getCompany_email());
        }
        if (dtoPersonInp.getPersonalEmail() != null) {
            setPersonalEmail(dtoPersonInp.getPersonalEmail());
        }
        if (dtoPersonInp.getCity() != null) {
            setCity(dtoPersonInp.getCity());
        }
        if (dtoPersonInp.getImage_url() != null) {
            setImage_url(dtoPersonInp.getImage_url());
        }
    }


}
