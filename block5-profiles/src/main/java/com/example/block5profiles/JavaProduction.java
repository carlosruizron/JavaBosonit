package com.example.block5profiles;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("PRODUCTION")
@Configuration
public class JavaProduction {

    @PostConstruct
    public void test() {
        System.out.println("Loaded production environment");
    }
}
