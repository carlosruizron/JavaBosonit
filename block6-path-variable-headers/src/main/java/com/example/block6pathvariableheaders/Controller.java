package com.example.block6pathvariableheaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


    @PostMapping("/greeting")
    public Greeting PostGreeting(@RequestBody Greeting greeting) {
        return greeting;
    }

    @GetMapping("/users/{id}")
    public String user(@PathVariable("id") String id){

        return "The id is:  " + id;
    }

    @PutMapping("/put")
    public Greeting updateList(@RequestParam("name") String name, Greeting greeting) {
        greeting.setId(1);
        greeting.setContent("Hello, " + name);

        return greeting;
    }

}
