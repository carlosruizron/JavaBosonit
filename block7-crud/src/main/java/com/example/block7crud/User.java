package com.example.block7crud;

import jakarta.persistence.*;
import lombok.Data;

// El @Data es una anotación de Lombok que nos crea constructor, setters y getters, equals etc automáticamente
@Data
// Indicamos a JPA que esta clase es una entidad
@Entity
// Indicamos la tabla que hace referencia a esa entidad
@Table(name="userName")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String city;

}
