package com.example.block7crudvalidation.subject.application.impls;

import com.example.block7crudvalidation.exception.EntityNotFoundException;
import com.example.block7crudvalidation.exception.UnprocessableEntityException;
import com.example.block7crudvalidation.subject.application.SubjectRepository;
import com.example.block7crudvalidation.subject.application.interfaces.SubjectService;
import com.example.block7crudvalidation.subject.domain.Subject;
import com.example.block7crudvalidation.subject.infrastucture.dto.DtoSubjectInp;
import com.example.block7crudvalidation.subject.infrastucture.dto.DtoSubjectOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public DtoSubjectOut createSubject(DtoSubjectInp dtoSubjectInp) throws UnprocessableEntityException {
        Subject subject = new Subject(dtoSubjectInp);
        subjectRepository.save(subject);
        return new DtoSubjectOut(subject);
    }

    @Override
    public DtoSubjectOut updateSubject(String id, DtoSubjectInp dtoSubjectInp) throws EntityNotFoundException {

        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con el id " + id + " no se encuentra"));
        subject.update(dtoSubjectInp);
        subjectRepository.save(subject);
        return new DtoSubjectOut(subject);
    }

    @Override
    public DtoSubjectOut readById(String id) throws EntityNotFoundException {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el usuario con el id " + id));
       return new DtoSubjectOut(subject);
    }

    @Override
    public List<DtoSubjectOut> getAll() {
        List<DtoSubjectOut> list = new ArrayList<>();
        subjectRepository.findAll().forEach(subject -> {
            DtoSubjectOut dtoSubjectOut = new DtoSubjectOut(subject);
            list.add(dtoSubjectOut);
        });
        return list;
    }

    @Override
    public void deleteUserById(String id) throws EntityNotFoundException {

        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No ha ningún usuario con esta id: " + id));
        subjectRepository.delete(subject);

    }
}
