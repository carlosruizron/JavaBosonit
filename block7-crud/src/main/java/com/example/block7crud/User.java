package com.example.block7crud;

import jakarta.persistence.*;
import lombok.Data;

// El @Data es una anotación de Lombok que nos crea constructor, setters y getters, equals etc automáticamente
@Data
@Entity
@Table(name="userName")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String city;

}
