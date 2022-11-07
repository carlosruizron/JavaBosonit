package com.example.block6simplecontrollers;

import org.springframework.web.bind.annotation.*;

@RestController

// Creamos el request mapping y le añadimos la ruta principal.
@RequestMapping(value = "/")
public class Controller {

    // Creamos el método get con el GetMapping
    @GetMapping("/users/{user}")

    public String user(@PathVariable("user") String name){
        return "Hello, my name is " + name;
    }

    // Creamos el método post con el PostMapping
    @PostMapping("/adduser")

    // Usamos el RequestBody para que los valores se recojan mediante el body
    public String personAdd(@RequestBody Person person){
        return person.getName() + " has " + (person.getAge() + 1);
    }
}
