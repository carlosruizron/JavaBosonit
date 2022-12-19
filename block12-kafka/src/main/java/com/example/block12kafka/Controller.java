package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private ProducerKafka producerKafka;

    @PostMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        String answer = "Se ha realizado exitosamente";
        try {
            producerKafka.send(message);
        } catch(Exception e) {
            answer = "Error";
        }
        return answer;
    }
}
