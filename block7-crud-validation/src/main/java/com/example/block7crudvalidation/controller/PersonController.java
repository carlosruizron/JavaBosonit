package com.example.block7crudvalidation.controller;

import com.example.block7crudvalidation.dto.DtoPersonInp;
import com.example.block7crudvalidation.application.PersonService;
import com.example.block7crudvalidation.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PersonService personService;

    @PostMapping(value="/createPerson")
    public DtoPersonOut createPerson (@RequestBody DtoPersonInp dtoPersonInp) throws Exception{

        return personService.createPerson(dtoPersonInp);
    }

    @PutMapping(value="/updatePerson")
    public DtoPersonOut updatePerson(@RequestBody DtoPersonInp dtoPersonInp) throws Exception{

        return personService.updatePerson(dtoPersonInp);
    }

    @GetMapping(value="/getByName/{name}")
    public List<DtoPersonOut> getByName(@PathVariable(name="name") String name) throws EntityNotFoundException{

        return personService.getByName(name);
    }

    @GetMapping(value="/getById/{id}")
    public DtoPersonOut getById(@PathVariable(name="id") Integer id) throws EntityNotFoundException {

        return personService.readById(id);
    }


    @GetMapping(value="getAll")
    public List<DtoPersonOut> getAll() {

        return personService.getAll();
    }

    @DeleteMapping(value="deleteById/{id}")
    public String deletePersonById(@PathVariable("id") Integer id) throws EntityNotFoundException {

       personService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }
}
