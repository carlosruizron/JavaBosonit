package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.dto.DtoPersonInp;
import com.example.block7crudvalidation.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws Exception;
    DtoPersonOut updatePerson(DtoPersonInp dtoPersonInp) throws Exception;
    List<DtoPersonOut> getByName(String name) throws EntityNotFoundException;
    DtoPersonOut readById(Integer id) throws EntityNotFoundException;
    List<DtoPersonOut> getAll();

    void deleteUserById(Integer id) throws EntityNotFoundException;
}
