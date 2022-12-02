package com.example.block7crudvalidation.student.application.impls;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.application.StudentRepository;
import com.example.block7crudvalidation.student.application.interfaces.StudentService;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentInp;
import com.example.block7crudvalidation.student.infrastucture.dto.DtoStudentOut;
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
    public DtoStudentOut updateStudent(String id, DtoStudentInp dtoStudentInp) throws EntityNotFoundException {

        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        student.update(dtoStudentInp);
        studentRepository.save(student);
        return new DtoStudentOut(student);
    }

    @Override
    public DtoStudentOut readById(String id) throws EntityNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el usuario con el id " + id));
       return new DtoStudentOut(student);
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
    public void deleteUserById(String id) throws EntityNotFoundException {

        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No ha ningún usuario con esta id: " + id));
           studentRepository.delete(student);

    }
}
