package com.example.block7crudvalidation.person.application.interfaces;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoStudentPerson;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoTeacherPerson;
import com.example.block7crudvalidation.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException;
    DtoPersonOut updatePerson(Integer id, DtoPersonInp dtoPersonInp);
    List<DtoPersonOut> getByName(String name) throws EntityNotFoundException;

    DtoPersonOut getByUsername(String username) throws EntityNotFoundException;
    DtoPersonOut readById(Integer id) throws EntityNotFoundException;
    List<DtoPersonOut> getAll();
    void deleteUserById(Integer id) throws EntityNotFoundException;

//    List<Student> getPersonStudent();
//    List<DtoTeacherPerson> getPersonTeacher();
}

