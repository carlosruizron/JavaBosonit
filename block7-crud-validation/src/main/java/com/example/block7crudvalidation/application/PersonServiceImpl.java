package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.DtoPerson;
import com.example.block7crudvalidation.Person;
import com.example.block7crudvalidation.exception.CreateUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;


    @Override
    public Person createPerson(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person updatePerson(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public List<Person> getByName(String name) {

        return personRepository.findByName(name);
    }

    @Override
    public Person getById(Integer id) throws CreateUserException {
       return personRepository.findById(id).orElseThrow(() -> new CreateUserException("No hay nadie con este id"));

    }

    @Override
    public List<Person> getAll() {

        return personRepository.findAll();
    }
}
