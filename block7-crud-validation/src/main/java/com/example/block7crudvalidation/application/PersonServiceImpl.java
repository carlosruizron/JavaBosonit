package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.dto.DtoPersonInp;
import com.example.block7crudvalidation.domain.Person;
import com.example.block7crudvalidation.dto.DtoPersonOut;
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
    public DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws Exception{
        Person person = new Person(dtoPersonInp);
        personRepository.save(person);
        return new DtoPersonOut(person);
    }

    @Override
    public DtoPersonOut updatePerson(DtoPersonInp dtoPersonInp) throws Exception{

        Person person = new Person(dtoPersonInp);
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
    public DtoPersonOut readById(Integer id) throws EntityNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
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
    public void deleteUserById(Integer id) throws EntityNotFoundException {
        personRepository.deleteById(id);

    }
}
