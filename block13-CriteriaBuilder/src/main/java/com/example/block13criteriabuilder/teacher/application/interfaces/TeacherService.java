package com.example.block13criteriabuilder.teacher.application.interfaces;

import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.teacher.domain.Teacher;
import com.example.block13criteriabuilder.teacher.infrastucture.dto.DtoTeacherInp;
import com.example.block13criteriabuilder.teacher.infrastucture.dto.DtoTeacherOut;

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
