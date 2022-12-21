package com.example.block13criteriabuilder.subject.application.interfaces;

import com.example.block13criteriabuilder.exception.EntityNotFoundException;
import com.example.block13criteriabuilder.exception.UnprocessableEntityException;
import com.example.block13criteriabuilder.subject.domain.Subject;
import com.example.block13criteriabuilder.subject.infrastucture.dto.DtoSubjectInp;
import com.example.block13criteriabuilder.subject.infrastucture.dto.DtoSubjectOut;
import java.util.List;


public interface SubjectService {

    DtoSubjectOut createSubject(DtoSubjectInp dtoSubjectInp) throws UnprocessableEntityException;
    DtoSubjectOut updateSubject(String id, DtoSubjectInp dtoSubjectInp);
    DtoSubjectOut readById(String id) throws EntityNotFoundException;
    List<DtoSubjectOut> getAll();
    void deleteUserById(String id) throws EntityNotFoundException;
    List<Subject> readEverySubject();
}
