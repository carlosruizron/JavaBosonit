package com.example.block16springcloud2.client;

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
}
