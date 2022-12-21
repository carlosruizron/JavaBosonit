package com.example.block13criteriabuilder.subject.application;

import com.example.block13criteriabuilder.subject.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {

}
