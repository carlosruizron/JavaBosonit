package com.example.block7crudvalidation.student.infrastucture.controller;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.application.interfaces.StudentService;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentInp;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentOut;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentOutFull;
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
    public DtoStudentOut getById(@PathVariable(name="id") Integer id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException {

        if (type.equals("full")) {
            return new DtoStudentOutFull(studentService.readById(id));
        }
        if (type.equals("simple")) {
            return new DtoStudentOut(studentService.readById(id)) ;
        }
        return null;
    }

    @PutMapping("/{id}")
    public DtoStudentOut updateStudent(@PathVariable("id") Integer id, @RequestBody DtoStudentInp dtoStudentInp){

        return studentService.updateStudent(id, dtoStudentInp);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") Integer id) throws EntityNotFoundException {

       studentService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }
}
