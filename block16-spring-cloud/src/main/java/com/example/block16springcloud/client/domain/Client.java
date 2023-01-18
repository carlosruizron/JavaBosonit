package com.example.block16springcloud.client.domain;

import com.example.block16springcloud.client.infrastucture.dto.DtoClientInp;
import com.example.block16springcloud.exception.UnprocessableEntityException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Client {

    @Id
    @GeneratedValue
    Integer idClient;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    Integer age;

    @Column
    String email;

    @Column
    String phone;

    public Client(DtoClientInp dtoClientInp) throws UnprocessableEntityException {

        if(dtoClientInp.getFirstName() == null) {
            throw new UnprocessableEntityException("El nombre no puede ser nulo");
        }else {
            setFirstName(dtoClientInp.getFirstName());
        }
        if(dtoClientInp.getLastName() == null) {
            throw new UnprocessableEntityException("El apellido no puede ser nulo");
        }else {
            setLastName(dtoClientInp.getLastName());
        }
        if(dtoClientInp.getAge() == null) {
            throw new UnprocessableEntityException("La edad no puede ser nula");
        }else {
            setAge(dtoClientInp.getAge());
        }
        if(dtoClientInp.getEmail() == null) {
            throw new UnprocessableEntityException("El email no puede ser nulo");
        }else {
            setEmail(dtoClientInp.getEmail());
        }
        if(dtoClientInp.getPhone() == null) {
            throw new UnprocessableEntityException("El teléfono no puede ser nulo");
        }else {
            setPhone(dtoClientInp.getPhone());
        }
    }

    public void update(DtoClientInp dtoClientInp) {
        if (dtoClientInp.getFirstName() != null) {
            setFirstName(dtoClientInp.getFirstName());
        }
        if (dtoClientInp.getLastName() != null) {
            setLastName(dtoClientInp.getLastName());
        }
        if (dtoClientInp.getAge() != null) {
            setAge(dtoClientInp.getAge());
        }
        if (dtoClientInp.getEmail() != null) {
            setEmail(dtoClientInp.getEmail());
        }
        if (dtoClientInp.getPhone() != null) {
            setPhone(dtoClientInp.getPhone());
        }
    }

}
