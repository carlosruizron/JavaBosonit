package com.example.block7crudvalidation;

import com.example.block7crudvalidation.exception.CreateUserException;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table
public class Person {

    @Id
    @GeneratedValue
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

    public Boolean checkData() throws CreateUserException {
        if((this.username.length() < 10) && (this.username.length() > 6)) {
            throw new CreateUserException("El usuario no puede estar nulo");
        } if (this.password == null) {
            throw new CreateUserException("La contraseña no puede ser null");
        } if (this.name == null) {
            throw new CreateUserException("El nombre no puede ser null");
        } if (this.surname == null) {
            throw new CreateUserException("El apellido no puede ser null");
        } if (this.company_email == null) {
            throw new CreateUserException("El email de la empresa no puede ser null");
        } if (this.personal_email == null) {
            throw new CreateUserException("El email personal no puede ser null");
        } if (this.city == null) {
            throw new CreateUserException("La ciudad no puede ser null");
        } if (this.active == null) {
            throw new CreateUserException("EL activador no puede ser null");
        } if (this.created_date == null) {
            throw new CreateUserException("La fecha de creación no puede ser null");
        }
        return true;

    }


}
