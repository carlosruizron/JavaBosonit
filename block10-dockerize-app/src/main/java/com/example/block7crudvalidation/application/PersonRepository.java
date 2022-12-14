package com.example.block7crudvalidation.application;

import com.example.block7crudvalidation.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository  extends JpaRepository<Person, String> {

    List<Person> findByName(String name);

}
