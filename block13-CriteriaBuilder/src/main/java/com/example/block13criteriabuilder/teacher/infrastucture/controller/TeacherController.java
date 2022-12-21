package com.example.block13criteriabuilder.teacher.infrastucture.controller;

import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.teacher.application.impls.TeacherServiceImpl;
import com.example.block13criteriabuilder.teacher.infrastucture.dto.DtoTeacherInp;
import com.example.block13criteriabuilder.teacher.infrastucture.dto.DtoTeacherOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherService;

    @PostMapping
    public DtoTeacherOut createTeacher (@RequestBody DtoTeacherInp dtoTeacherInp) throws UnprocessableEntityException {

        return teacherService.createTeacher(dtoTeacherInp);
    }

    @GetMapping
    public List<DtoTeacherOut> getAll() {

        return teacherService.getAll();
    }

    @GetMapping("/{id}")
    public DtoTeacherOut getById(@PathVariable(name="id") Integer id) throws EntityNotFoundException {

        return teacherService.readById(id);
    }

    @PutMapping("/{id}")
    public DtoTeacherOut updateTeacher(@PathVariable("id") Integer id, @RequestBody DtoTeacherInp dtoTeacherInp){

        return teacherService.updateTeacher(id, dtoTeacherInp);
    }

    @DeleteMapping("/{id}")
    public String deletePersonById(@PathVariable("id") Integer id) throws EntityNotFoundException {

       teacherService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }
}
