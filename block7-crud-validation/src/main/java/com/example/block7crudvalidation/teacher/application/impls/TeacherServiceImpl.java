package com.example.block7crudvalidation.teacher.application.impls;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.student.domain.Student;
import com.example.block7crudvalidation.teacher.application.TeacherRepository;
import com.example.block7crudvalidation.teacher.application.interfaces.TeacherService;
import com.example.block7crudvalidation.teacher.domain.Teacher;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherInp;
import com.example.block7crudvalidation.teacher.infrastucture.dto.DtoTeacherOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public DtoTeacherOut createTeacher(DtoTeacherInp dtoTeacherInp) throws UnprocessableEntityException {
        Teacher teacher = new Teacher(dtoTeacherInp);
        teacherRepository.save(teacher);
        return new DtoTeacherOut(teacher);
    }
    @Override
    public DtoTeacherOut updateTeacher(Integer id, DtoTeacherInp dtoTeacherInp) throws EntityNotFoundException {

        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        teacher.update(dtoTeacherInp);
        teacherRepository.save(teacher);
        return new DtoTeacherOut(teacher);
    }
    @Override
    public DtoTeacherOut readById(Integer id) throws EntityNotFoundException {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el usuario con el id " + id));
       return new DtoTeacherOut(teacher);
    }
    @Override
    public List<DtoTeacherOut> getAll() {
        List<DtoTeacherOut> list = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher -> {
            DtoTeacherOut dtoTeacherOut = new DtoTeacherOut(teacher);
            list.add(dtoTeacherOut);
        });
        return list;
    }
    @Override
    public void deleteUserById(Integer id) throws EntityNotFoundException {

        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No ha ningún usuario con esta id: " + id));
           teacherRepository.delete(teacher);

    }
    @Override
    public List<Teacher> readEveryTeacher() {
        List<Teacher> allTeacher = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher -> allTeacher.add(teacher));
        return allTeacher;
    }
    @Override
    public Boolean filterByID(List<Teacher> list, Integer id) {
        List<Teacher> teacherResult = new ArrayList<>();
        list.stream().filter(Teacher -> Teacher.getPerson().getId_person() == id).forEach(teacher -> teacherResult.add(teacher));
        return (teacherResult.size() != 0);
    }
    @Override
    public Teacher getById(List<Teacher> list, Integer id) {
        List<Teacher> teacherRecover = new ArrayList<>();
        list.stream().filter(Teacher -> Teacher.getPerson().getId_person() == id).forEach(teacher -> teacherRecover.add(teacher));
        return teacherRecover.get(0);
    }
    @Override
    public Boolean filterByTeacher(List<Teacher> list) {
        List<Teacher> teacherResult = new ArrayList<>();
        list.stream().filter(Teacher -> Teacher.getPerson().getId_person() != null).forEach(teacher -> teacherResult.add(teacher));
        return (teacherResult.size() > 0);
    }
}
