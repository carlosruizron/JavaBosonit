package com.example.block16springcloud.client.infrastucture.dto;

import com.example.block16springcloud.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoClientOut {

    private Integer idClient;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phone;

    public DtoClientOut(Client client) {

        setIdClient(client.getIdClient());
        setFirstName(client.getFirstName());
        setLastName(client.getLastName());
        setAge(client.getAge());
        setEmail(client.getEmail());
        setPhone(client.getPhone());
    }


}
