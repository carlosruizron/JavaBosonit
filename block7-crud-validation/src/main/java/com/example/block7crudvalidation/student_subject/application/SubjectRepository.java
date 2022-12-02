package com.example.block7crudvalidation.student_subject.application;

import com.example.block7crudvalidation.student_subject.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

}
