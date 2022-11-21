package com.example.block6simplecontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController

// Creamos el request mapping y le añadimos la ruta principal.
@RequestMapping(value = "/add")
public class Controller {

//    @Mapping
//    public String user(){
//
//        return String.format("Hello, my name is Carlos");
//    }

//     Creamos el método get con el GetMapping
    @GetMapping("user")

    public String user(@PathVariable("user") String name){

        return String.format("Hello, my name is " + name);
    }


//    @GetMapping("arg2")
//    @ResponseStatus(HttpStatus.OK)
//    public String user2(@PathVariable String arg2){
//
//        return "http" + HttpStatus.OK;
//    }
//
//    // Creamos el método post con el PostMapping
//    @PostMapping("/adduser")
//
//    // Usamos el RequestBody para que los valores se recojan mediante el body
//    public String personAdd(@RequestBody Person person){
//        return person.getName() + " has " + (person.getAge() + 1);
//    }
}
