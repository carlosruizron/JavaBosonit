package com.example.block7crudvalidation.person.application;

import com.example.block7crudvalidation.person.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
    Person findByUsername(String email);

}
