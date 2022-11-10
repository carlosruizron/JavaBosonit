package com.example.block6personcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Autowired
    Person2 person2;

    @Bean
    public Person2 bean1() {
        Person2 person2 = new Person2();
        person2.setName("Carlos");
        person2.setCity("Málaga");
        person2.setAge(23);
        return person2;
    }

    @Bean
    public Person2 bean2() {
        Person2 person2 = new Person2();
        person2.setName("Alfonso");
        person2.setCity("Madrid");
        person2.setAge(40);
        return person2;
    }

    @Bean
    public Person2 bean3() {
        Person2 person2 = new Person2();
        person2.setName("Jorge");
        person2.setCity("Padilla");
        person2.setAge(15);
        return person2;
    }

}
