package com.example.block13mongodb.infrastructure.controller;

import com.example.block13mongodb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@RestController
@RequestMapping("personMongo")
public class PersonController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoRepository mongoRepository;

    @PostMapping
    public Person createPerson(@RequestBody Person person) {

        mongoTemplate.save(person);
        return person;
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable("id") Integer id) {

        return mongoTemplate.save(person);
    }

    @GetMapping
    public Page<Person> getAll(Pageable pageable) {

        return mongoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {

        return mongoTemplate.findById(id, Person.class);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {

        Person person = mongoTemplate.findById(id, Person.class);
        mongoTemplate.remove(person);
        return "Borrado correctamente el usuario con le id: " + id;
    }
}
