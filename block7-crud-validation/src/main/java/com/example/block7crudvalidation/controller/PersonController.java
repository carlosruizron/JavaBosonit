package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.DtoPerson;
import com.example.block7crudvalidation.Person;
import com.example.block7crudvalidation.application.PersonServiceImpl;
import com.example.block7crudvalidation.exception.CreateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/createPerson")
    public Person createPerson(@RequestBody Person person) throws Exception {
        if(person.checkData() == true) {
            personService.createPerson(person);
            return person;
        }else {
            throw new CreateUserException("mal");
        }
    }

    @GetMapping("getAll")
    public List<Person> getAll() {
        return personService.getAll();
    }
}
