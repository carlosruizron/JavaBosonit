package com.example.block13criteriabuilder.person.application;

import com.example.block13criteriabuilder.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

}
