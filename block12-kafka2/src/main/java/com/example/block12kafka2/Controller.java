package com.example.block12kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private ProducerKafka2 producerKafka2;

    @PostMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {

        try {
            producerKafka2.sendMessage(message);
            return "Se ha realizado con éxito";
        } catch(Exception e) {
            return "Error";
        }
    }
}
