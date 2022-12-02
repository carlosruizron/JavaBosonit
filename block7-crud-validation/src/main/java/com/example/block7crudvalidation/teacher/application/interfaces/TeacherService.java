package com.example.block7crudvalidation.teacher.application.interfaces;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherInp;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherOut;

import java.util.List;

public interface TeacherService {

    DtoTeacherOut createTeacher(DtoTeacherInp dtoTeacherInp) throws UnprocessableEntityException;
    DtoTeacherOut updateTeacher(String id, DtoTeacherInp dtoTeacherInp);
    DtoTeacherOut readById(String id) throws EntityNotFoundException;
    List<DtoTeacherOut> getAll();

    void deleteUserById(String id) throws EntityNotFoundException;
}
