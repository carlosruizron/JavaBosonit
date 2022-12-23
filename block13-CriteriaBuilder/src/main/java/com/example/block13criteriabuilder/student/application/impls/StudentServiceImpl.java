package com.example.block13criteriabuilder.student.application.impls;

import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.student.application.StudentRepository;
import com.example.block13criteriabuilder.student.application.interfaces.StudentService;
import com.example.block13criteriabuilder.student.domain.Student;
import com.example.block13criteriabuilder.student.infrastucture.dto.DtoStudentInp;
import com.example.block13criteriabuilder.student.infrastucture.dto.DtoStudentOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public DtoStudentOut createStudent(DtoStudentInp dtoStudentInp) throws UnprocessableEntityException {
        Student student = new Student(dtoStudentInp);
        studentRepository.save(student);
        return new DtoStudentOut(student);
    }

    @Override
    public DtoStudentOut updateStudent(Integer id, DtoStudentInp dtoStudentInp) throws EntityNotFoundException {

        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        student.update(dtoStudentInp);
        studentRepository.save(student);
        return new DtoStudentOut(student);
    }

    @Override
    public Student readById(Integer id) throws EntityNotFoundException {
       return  studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No student found with id: " + id));
    }

    @Override
    public List<DtoStudentOut> getAll() {
        List<DtoStudentOut> list = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            DtoStudentOut dtoStudentOut = new DtoStudentOut(student);
            list.add(dtoStudentOut);
        });
        return list;
    }

    @Override
    public void deleteUserById(Integer id) throws EntityNotFoundException {

        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No ha ningún usuario con esta id: " + id));
           studentRepository.delete(student);

    }

    @Override
    public List<Student> readEveryStudent() {
        List<Student> allStudent = new ArrayList<>();
        studentRepository.findAll().forEach(student -> allStudent.add(student));
        return allStudent;
    }

    @Override
    public Boolean filterByID(List<Student> list, Integer id) {
        List<Student> studentResult = new ArrayList<>();
        list.stream().filter(Student -> Student.getPerson().getIdPerson() == id).forEach(student -> studentResult.add(student));
        return (studentResult.size() > 0);
    }

    //Una vez pasado el if, devolvemos el Student indicado con la ID exigida
    @Override
    public Student getById(List<Student> list, Integer id) {
        List<Student> studentRecover= new ArrayList<>();
        list.stream().filter(Student -> Student.getPerson().getIdPerson() == id).forEach(student -> studentRecover.add(student));
        return studentRecover.get(0);
    }

//    @Override
//    public Boolean filterByStudent(List<Student> list) {
//        List<Student> studentResult = new ArrayList<>();
//        list.stream().filter(Student -> Student.getPerson().getId_person() != null).forEach(student -> studentResult.add(student));
//        return (studentResult.size() > 0);
//    }

}
