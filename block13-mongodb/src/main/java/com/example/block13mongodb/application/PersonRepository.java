package com.example.block13mongodb.application;

import com.example.block13mongodb.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer> {
}
