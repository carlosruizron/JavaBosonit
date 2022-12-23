package com.example.block13criteriabuilder.person.application.interfaces;

import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.person.domain.Person;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoPersonInp;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoPersonOut;
import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException;
    DtoPersonOut updatePerson(Integer id, DtoPersonInp dtoPersonInp);
    List<DtoPersonOut> getByName(String name) throws EntityNotFoundException;
    DtoPersonOut readById(Integer id) throws EntityNotFoundException;
    Page<Person> getAll(Pageable pageable);
    void deleteUserById(Integer id) throws EntityNotFoundException;

//    List<Student> getPersonStudent();
//    List<DtoTeacherPerson> getPersonTeacher();
}

