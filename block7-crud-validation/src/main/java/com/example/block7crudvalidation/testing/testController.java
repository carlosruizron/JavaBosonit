package com.example.block7crudvalidation.testing;

import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.person.application.interfaces.PersonService;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonOut;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class testController {

    @Autowired
    PersonService personService;

    @Test
    public DtoPersonOut createPerson (@RequestBody DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {

        assert
        return personService.createPerson(dtoPersonInp);
    }
}
