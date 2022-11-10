package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    @Autowired
    City city;

    @Autowired
    Person person;

    @GetMapping ("/controller2/getPersona")
    public String getPersona () {
        return person.getName() + " tiene " + (person.getAge() * 2) + " años y es de " + person.getCity();
    }

    @GetMapping ("/controller2/getCity")
    public String getCity () {
        return city.getName() + " tiene " + city.getPopulation();
    }
}
