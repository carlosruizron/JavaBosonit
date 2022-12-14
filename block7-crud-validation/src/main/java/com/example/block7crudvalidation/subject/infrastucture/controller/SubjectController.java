package com.example.block7crudvalidation.subject.infrastucture.controller;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.application.impls.StudentServiceImpl;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.subject.application.impls.SubjectServiceImpl;
import com.example.block7crudvalidation.subject.domain.Subject;
import com.example.block7crudvalidation.subject.infrastucture.dto.DtoSubjectInp;
import com.example.block7crudvalidation.subject.infrastucture.dto.DtoSubjectOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectServiceImpl subjectService;

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping
    public DtoSubjectOut createSubject (@RequestBody DtoSubjectInp dtoSubjectInp) throws UnprocessableEntityException {

        return subjectService.createSubject(dtoSubjectInp);
    }

    @GetMapping
    public List<DtoSubjectOut> getAll() {

        return subjectService.getAll();
    }

    @GetMapping("/{id}")
    public DtoSubjectOut getById(@PathVariable(name="id") String id) throws EntityNotFoundException {

        return subjectService.readById(id);
    }


    @PutMapping("/{id}")
    public DtoSubjectOut updateSubject(@PathVariable("id") String id, @RequestBody DtoSubjectInp dtoSubjectInp){

        return subjectService.updateSubject(id, dtoSubjectInp);
    }

    @DeleteMapping("/{id}")
    public String deleteSubjectById(@PathVariable("id") String id) throws EntityNotFoundException {

       subjectService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }

    @GetMapping("/student/{id}")
    public List<Subject> readByStudentId(@PathVariable("id") Integer id) throws Exception {
        List<Subject> subjectsResult = new ArrayList<>();
        List<Subject> listSubjects;

        Student student = studentService.readById(id);
        listSubjects = subjectService.readEverySubject();
        listSubjects.stream().filter(Subject -> Subject.getStudent().getId_student() == id).forEach(subject -> subjectsResult.add(subject));
        return subjectsResult;
    }
}
