package com.example.block7crudvalidation.student.application.interfaces;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentInp;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    DtoStudentOut createStudent(DtoStudentInp dtoStudentInp) throws UnprocessableEntityException;
    DtoStudentOut updateStudent(String id, DtoStudentInp dtoStudentInp);
    DtoStudentOut readById(String id) throws EntityNotFoundException;
    List<DtoStudentOut> getAll();

    void deleteUserById(String id) throws EntityNotFoundException;
}
