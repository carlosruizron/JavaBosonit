package com.example.block13mongodb.infrastructure.controller;

import com.example.block13mongodb.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.mongodb.core.query.Query;
import java.util.List;

@RestController
@RequestMapping("personMongo")
public class PersonController {

    @Autowired
    MongoTemplate mongoTemplate;

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
    public List<Person> getAll() {

        int pageSize = 1;
        int pageNumber= 2;

        Query query = new Query();
        query.skip(pageNumber * pageSize);
        query.limit(pageSize);
        return mongoTemplate.find(query, Person.class);
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
