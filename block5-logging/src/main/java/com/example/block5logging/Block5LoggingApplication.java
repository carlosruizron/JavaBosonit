package com.example.block5logging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

@SpringBootApplication
public class Block5LoggingApplication implements CommandLineRunner {

    private static Logger Log = Logger.getLogger("logging");

    public static void main(String[] args) {
        SpringApplication.run(Block5LoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        FileHandler handler = new FileHandler("./src/main/resources/spring-logging.log", true);
        Log.addHandler(handler);

        Log.warning("Esto es una advertencia");
        Log.severe("Esto es un error grave");
        Log.info("El proceso a finalizado");

    }

}
