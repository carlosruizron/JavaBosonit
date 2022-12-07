package com.example.block7crudvalidation.teacher.application.interfaces;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherInp;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherOut;

import java.util.List;

public interface TeacherService {

    DtoTeacherOut createTeacher(DtoTeacherInp dtoTeacherInp) throws UnprocessableEntityException;
    DtoTeacherOut updateTeacher(Integer id, DtoTeacherInp dtoTeacherInp);
    DtoTeacherOut readById(Integer id) throws EntityNotFoundException;
    List<DtoTeacherOut> getAll();
    void deleteUserById(Integer id) throws EntityNotFoundException;
    List<Teacher> readEveryTeacher();
    Boolean filterByID(List<Teacher> list, Integer id);
    public Teacher getById(List<Teacher> list, Integer id);
    Boolean filterByTeacher(List<Teacher> list);
}
