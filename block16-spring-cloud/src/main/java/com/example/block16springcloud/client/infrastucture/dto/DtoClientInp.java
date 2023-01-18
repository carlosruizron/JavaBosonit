package com.example.block16springcloud.client.infrastucture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DtoClientInp implements Serializable {

    Integer idClient;
    String firstName;
    String lastName;
    Integer age;
    String email;
    String phone;
}
