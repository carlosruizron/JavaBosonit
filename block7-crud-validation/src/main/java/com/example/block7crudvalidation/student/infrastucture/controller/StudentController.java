package com.example.block7crudvalidation.student.infrastucture.controller;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.application.interfaces.StudentService;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentInp;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public DtoStudentOut createStudent (@RequestBody DtoStudentInp dtoStudentInp) throws UnprocessableEntityException {

        return studentService.createStudent(dtoStudentInp);
    }

    @GetMapping
    public List<DtoStudentOut> getAll() {

        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public DtoStudentOut getById(@PathVariable(name="id") String id) throws EntityNotFoundException {

        return studentService.readById(id);
    }

    @PutMapping("/{id}")
    public DtoStudentOut updateStudent(@PathVariable("id") String id, @RequestBody DtoStudentInp dtoStudentInp){

        return studentService.updateStudent(id, dtoStudentInp);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") String id) throws EntityNotFoundException {

       studentService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }
}
