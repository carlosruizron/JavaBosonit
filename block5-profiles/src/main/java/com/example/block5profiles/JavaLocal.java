package com.example.block5profiles;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local")
@Configuration
public class JavaLocal {

    @PostConstruct
    public void test() {
        System.out.println("Loaded local environment");
    }
}
