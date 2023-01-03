package com.example.block7crudvalidation;


import com.example.block7crudvalidation.person.application.PersonRepository;
import com.example.block7crudvalidation.person.application.impls.PersonServiceImpl;
import com.example.block7crudvalidation.person.domain.Person;
import com.example.block7crudvalidation.person.infrastucture.dto.DtoPersonInp;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControllerPersonTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    PersonServiceImpl personService;

    Person person;
    DtoPersonInp dtoPersonInp;

    @BeforeEach
    void personCreated() {
        dtoPersonInp = DtoPersonInp.builder()
                .id_person(1)
                .name("Carlos")
                .surname("Ruiz")
                .username("carlosruiz")
                .company_email("bosonit.com")
                .personal_email("carlos@bosonit.com")
                .city("Malaga")
                .active(true)
                .created_date(new Date())
//                .termination_date(new SimpleDateFormat("2076-10-10"))
                .image_url("http://www.holaquepasa.com")
                .password("gimmeMoreChrome")
                .build();
    }

    @Test
    @Order(1)
    void savePersonTest() {
        when(personRepository.save(any(Person.class))).thenReturn((person));
        assertNotNull(personService.createPerson(dtoPersonInp));
    }
}

