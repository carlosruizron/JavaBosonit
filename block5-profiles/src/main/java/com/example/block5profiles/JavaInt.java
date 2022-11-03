package com.example.block5profiles;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("INTEGRATION")
@Configuration
public class JavaInt {

    @PostConstruct
    public void test() {
        System.out.println("Loaded INTEGRATION environment");
    }
}
