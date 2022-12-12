package com.example.block7crudvalidation.application.impls;

import com.example.block7crudvalidation.application.PersonRepository;
import com.example.block7crudvalidation.application.interfaces.PersonService;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.domain.Person;
import com.example.block7crudvalidation.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {
        Person person = new Person(dtoPersonInp);
        personRepository.save(person);
        return new DtoPersonOut(person);
    }

    @Override
    public DtoPersonOut updatePerson(String id, DtoPersonInp dtoPersonInp) throws EntityNotFoundException{

        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        person.update(dtoPersonInp);
        personRepository.save(person);
        return new DtoPersonOut(person);
    }

    @Override
    public List<DtoPersonOut> getByName(String name) throws EntityNotFoundException{

        List<DtoPersonOut> list = new ArrayList<>();
        personRepository.findByName(name).forEach(person -> {
            list.add(new DtoPersonOut(person));
        });
        return list;
    }

    @Override
    public DtoPersonOut readById(String id) throws EntityNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el usuario con el id " + id));
       return new DtoPersonOut(person);
    }

    @Override
    public List<DtoPersonOut> getAll() {
        List<DtoPersonOut> list = new ArrayList<>();
        personRepository.findAll().forEach(person -> {
            DtoPersonOut dtoPersonOut = new DtoPersonOut(person);
            list.add(dtoPersonOut);
        });
        return list;
    }

    @Override
    public void deleteUserById(String id) throws EntityNotFoundException {

        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No hay ningún usuario con esta id: " + id));
           personRepository.delete(person);

    }
}
