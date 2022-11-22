package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.DtoPerson;
import com.example.block7crudvalidation.Person;
import com.example.block7crudvalidation.exception.CreateUserException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    Person createPerson(Person person);
    Person updatePerson(Person person);
    List<Person> getByName(String name);
    Person getById(Integer id) throws CreateUserException;
    List<Person> getAll();
}
