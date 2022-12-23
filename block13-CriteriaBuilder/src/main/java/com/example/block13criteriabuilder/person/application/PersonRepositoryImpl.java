package com.example.block13criteriabuilder.person.application;

import com.example.block13criteriabuilder.person.domain.Person;
import com.example.block13criteriabuilder.person.infrastucture.dto.DtoPersonOut;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<DtoPersonOut>  getPersonQuery(HashMap<String, String> conditions) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> query = cb.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((filed, value) -> {
            switch (filed) {
                case "name", "surname":
                    predicates.add(cb.like(root.get(filed),
                            "%" + (String) value + "%"));
                    break;
                case "dateGreaterThan":
                    try {
                        predicates.add(cb.greaterThan(root.get("created_date"),new SimpleDateFormat("yyyy-mm-dd").parse(value)));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "dateLessThan":
                    try {
                        predicates.add(cb.lessThan(root.get("created_date"), new SimpleDateFormat("yyyy-mm-dd").parse(value)));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
            }
        });
        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager
                .createQuery(query)
                .getResultList()
                .stream()
                .map(DtoPersonOut::new)
                .toList();
    }
}
