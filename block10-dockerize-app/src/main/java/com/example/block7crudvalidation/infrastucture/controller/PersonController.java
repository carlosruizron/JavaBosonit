package com.example.block7crudvalidation.infrastucture.controller;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.application.interfaces.PersonService;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping
    public DtoPersonOut createPerson (@RequestBody DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {

        return personService.createPerson(dtoPersonInp);
    }

    @GetMapping
    public List<DtoPersonOut> getAll() {

        return personService.getAll();
    }

    @GetMapping("/{id}")
    public DtoPersonOut getById(@PathVariable(name="id") String id) throws EntityNotFoundException {

        return personService.readById(id);
    }

    @GetMapping("/name/{name}")
    public List<DtoPersonOut> getByName(@PathVariable(name="name") String name) throws EntityNotFoundException{

        return personService.getByName(name);
    }

    @PutMapping("/{id}")
    public DtoPersonOut updatePerson(@PathVariable("id") String id, @RequestBody DtoPersonInp dtoPersonInp){

        return personService.updatePerson(id, dtoPersonInp);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") String id) throws EntityNotFoundException {

       personService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }
}
