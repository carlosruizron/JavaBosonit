package com.example.block13criteriabuilder.person.infrastucture.controller;

import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.feign.FeignServer;
import com.example.block13criteriabuilder.person.application.PersonRepositoryImpl;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoPersonInp;
import com.example.block13criteriabuilder.person.application.interfaces.PersonService;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoPersonOut;
import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoStudentPerson;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoTeacherPerson;
import com.example.block13criteriabuilder.student.application.interfaces.StudentService;
import com.example.block13criteriabuilder.student.domain.Student;
import com.example.block13criteriabuilder.teacher.application.interfaces.TeacherService;
import com.example.block13criteriabuilder.teacher.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    PersonRepositoryImpl personRepositoryImpl;

    @Autowired
    FeignServer feignServer;

    @PostMapping
    public DtoPersonOut createPerson (@RequestBody DtoPersonInp dtoPersonInp) throws UnprocessableEntityException {

        return personService.createPerson(dtoPersonInp);
    }

    @CrossOrigin(origins = "https://cdpn.io")
    @GetMapping
    public List<DtoPersonOut> getAll() {
        return personService.getAll();
    }

    @CrossOrigin(origins = "https://cdpn.io")
    @GetMapping(value="/{id}")
    public DtoPersonOut getById(@PathVariable(name="id") Integer id, @RequestParam(name = "outputType", defaultValue = "simple") String type) throws EntityNotFoundException {

        if(type.equals("full")) {

            List<Student> listStudent = studentService.readEveryStudent();
            List<Teacher> listTeacher = teacherService.readEveryTeacher();

            if(studentService.filterByID(listStudent, id)) {
                DtoStudentPerson dtoStudentPerson = new DtoStudentPerson();
                Student student = new Student();
                student = studentService.getById(listStudent, id);
                dtoStudentPerson.getStudentPerson(student);
                return dtoStudentPerson;
            }
            if (teacherService.filterByID(listTeacher, id)) {
                DtoTeacherPerson dtoTeacherPerson = new DtoTeacherPerson();
                Teacher teacher = new Teacher();
                teacher = teacherService.getById(listTeacher, id);
                dtoTeacherPerson.getTeacherPerson(teacher);
                return dtoTeacherPerson;
            }
            else {
                return personService.readById(id);

            }
        }
        if(type.equals("simple")) {
            return personService.readById(id);
        }
        return null;
    }

    @GetMapping(value="/name/{name}")
    public List<DtoPersonOut> getByName(@PathVariable(name="name") String name) throws EntityNotFoundException {

        return personService.getByName(name);
    }

    @CrossOrigin(origins = "https://cdpn.io")
    @PutMapping(value="/{id}")
    public DtoPersonOut updatePerson(@PathVariable("id") Integer id, @RequestBody DtoPersonInp dtoPersonInp){

        return personService.updatePerson(id, dtoPersonInp);
    }

    @DeleteMapping(value="/{id}")
    public String deletePersonById(@PathVariable("id") Integer id) throws EntityNotFoundException {

       personService.deleteUserById(id);
       return "Se ha eliminado el usuario con el id: " + id;
    }

//    Feign
    @GetMapping("/teacher/{id}")
    public DtoTeacherPerson getTeacherById(@PathVariable("id") Integer id) {
        return feignServer.readTeacherById(id, "full");
    }

//    CriteriaBuilder

    @GetMapping("/personQuery")
    public Iterable<DtoPersonOut> getPersonByCriteria(@RequestParam(required = false) String Type, @RequestParam HashMap<String, String> conditions) {

        HashMap<String, String> data = new HashMap<>();

        return personRepositoryImpl.getPersonQuery(conditions);
    }
}
