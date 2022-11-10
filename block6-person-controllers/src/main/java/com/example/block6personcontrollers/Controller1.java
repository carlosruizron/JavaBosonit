package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @Autowired
    City city;

    @Autowired
    Person person;

    // Creamos la url
    @GetMapping("/controller1/addPerson")
    //  Creamos método donde recoja los valores desde el header
    public String addPerson(@RequestHeader("name") String name, @RequestHeader("age") int age, @RequestHeader("city") String city) {

        // Insertamos los valores recogidos en el header
        person.setName(name);
        person.setCity(city);
        person.setAge(age);

        // Enseñamos los valores insertados
        return person.getName() + " tiene " + person.getAge() + " años y es de " + person.getCity();
    }

    @PostMapping("/controller1/addCity")
    public String addCity(@RequestHeader("name") String name, @RequestHeader("population") int population){
        city.setName(name);
        city.setPopulation(population);

        return "Se a añadido la ciudad " + name + " que tiene una población de " + population + " habitantes.";
    }
}
