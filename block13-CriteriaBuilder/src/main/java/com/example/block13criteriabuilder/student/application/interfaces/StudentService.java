package com.example.block13criteriabuilder.student.application.interfaces;

import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.student.domain.Student;
import com.example.block13criteriabuilder.student.infrastucture.dto.DtoStudentInp;
import com.example.block13criteriabuilder.student.infrastucture.dto.DtoStudentOut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    DtoStudentOut createStudent(DtoStudentInp dtoStudentInp) throws UnprocessableEntityException;
    DtoStudentOut updateStudent(Integer id, DtoStudentInp dtoStudentInp);
    Student readById(Integer id) throws EntityNotFoundException;
    List<DtoStudentOut> getAll();
    void deleteUserById(Integer id) throws EntityNotFoundException;
    List<Student> readEveryStudent();
    Boolean filterByID(List<Student> list, Integer id);
    Student getById(List<Student> list, Integer id);
//    Boolean filterByStudent(List<Student> list);
}
