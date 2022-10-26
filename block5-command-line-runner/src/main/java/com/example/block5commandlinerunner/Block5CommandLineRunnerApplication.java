package com.example.block5commandlinerunner;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Block5CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Block5CommandLineRunnerApplication.class, args);

	}

    // Uso el PostConstruct para el primer mensaje ya que este se ejecuta antes que le run
	@PostConstruct
	public static void FirstHello() {
		System.out.println("Hola desde clase inicial");
	}

	// Creamos los dos metodos siguientes
	@Bean
	CommandLineRunner SecondHello() {
		return hello -> {
			System.out.println("Hola desde la segunda clase");
		};
	}

	@Bean
	CommandLineRunner ThirdHello() {
		return hello -> {
			System.out.println("Hola desde la tercera clase");
		};
	}

	// Sobreescribimos el run para que realice los dos metodos anteriores
	@Override
	public void run(String... args) throws Exception {
		SecondHello();
		ThirdHello();
	}





}
