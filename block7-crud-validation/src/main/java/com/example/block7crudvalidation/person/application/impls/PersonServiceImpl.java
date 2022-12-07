package com.example.block7crudvalidation.person.application.impls;

import com.example.block7crudvalidation.person.application.PersonRepository;
import com.example.block7crudvalidation.person.application.interfaces.PersonService;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonInp;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonOut;
import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoStudentPerson;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoTeacherPerson;
import com.example.block7crudvalidation.student.application.StudentRepository;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.teacher.application.TeacherRepository;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public DtoPersonOut createPerson(DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {
        Person person = new Person(dtoPersonInp);
        personRepository.save(person);
        return new DtoPersonOut(person);
    }

    @Override
    public DtoPersonOut updatePerson(Integer id, DtoPersonInp dtoPersonInp) throws EntityNotFoundException {

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
    public DtoPersonOut readById(Integer id) throws EntityNotFoundException {
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
    public void deleteUserById(Integer id) throws EntityNotFoundException {

        Person person = personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No ha ningún usuario con esta id: " + id));
           personRepository.delete(person);

    }

//        public List<Student> getPersonStudent() {
//        List<Student> list = new ArrayList<>();
//        studentRepository.findAll().forEach(student -> {
//            list.add(student);
//        });
//        return list;
//    }
//
//    public List<DtoTeacherPerson> getPersonTeacher() {
//        List<DtoTeacherPerson> list = new ArrayList<>();
//        teacherRepository.findAll().forEach(teacher -> {
//            DtoTeacherPerson dtoTeacherPerson = new DtoTeacherPerson(teacher);
//            list.add(dtoTeacherPerson);
//        });
//        return list;
//    }


}
