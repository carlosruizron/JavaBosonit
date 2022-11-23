package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.DtoPerson;
import com.example.block7crudvalidation.Person;
import com.example.block7crudvalidation.application.PersonService;
import com.example.block7crudvalidation.exception.CreateUserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonService personService;

    @PostMapping(value="/createPerson")
    public ResponseEntity<DtoPerson> createPerson (@RequestBody DtoPerson dtoPerson) throws Exception {

        // Convertimos el dto a entidad.
        Person personRequest = modelMapper.map(dtoPerson, Person.class);

        Person person = personService.createPerson(personRequest);

        // Convertimos ahora la entidad a dto.
        DtoPerson personResponse = modelMapper.map(person, DtoPerson.class);

        return new ResponseEntity<DtoPerson>(personResponse, HttpStatus.CREATED);
    }

    @PutMapping(value="/updatePerson")
    public ResponseEntity<DtoPerson> updatePerson(@RequestBody DtoPerson dtoPerson) {

        // Convertimos dto a entidad
        Person personRequest = modelMapper.map(dtoPerson, Person.class);

        Person person = personService.updatePerson(personRequest);

        // Entidad a Dto
        DtoPerson personResponse = modelMapper.map(person, DtoPerson.class);

        return ResponseEntity.ok().body(personResponse);


    }

    @GetMapping(value="/getByName/{name}")
    public List<DtoPerson> getByName(@PathVariable(name="name") String name) {

        return personService.getByName(name).stream().map(person -> modelMapper.map(person, DtoPerson.class)).collect(Collectors.toList());

    }

    @GetMapping(value="/getById/{id}")
    public ResponseEntity<DtoPerson> getById(@PathVariable(name="id") Integer id) throws CreateUserException {
        Person person = personService.getById(id);

        // Convertimos entidad a Dto
        DtoPerson personResponse = modelMapper.map(person, DtoPerson.class);

        return ResponseEntity.ok().body(personResponse);
    }



    @GetMapping(value="getAll")
    public List<DtoPerson> getAll() {

        return personService.getAll().stream().map(person -> modelMapper.map(person, DtoPerson.class)).collect(Collectors.toList());
    }
}
