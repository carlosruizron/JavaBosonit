package com.example.block7crudvalidation.application.interfaces;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException;
    DtoPersonOut updatePerson(String id, DtoPersonInp dtoPersonInp);
    List<DtoPersonOut> getByName(String name) throws EntityNotFoundException;
    DtoPersonOut readById(String id) throws EntityNotFoundException;
    List<DtoPersonOut> getAll();

    void deleteUserById(String id) throws EntityNotFoundException;
}
