package com.example.block6personcontrollers;

import org.springframework.stereotype.Component;

@Component
public class Person2 {

    private String name;
    private String city;
    private int age;

    Person2(){}

    Person2 (String name, String city, int age) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

}
