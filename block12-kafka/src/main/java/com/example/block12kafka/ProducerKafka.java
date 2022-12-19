package com.example.block12kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerKafka {

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    private final String kafkaTopic = "topic";

    public void send(String message) {
    KafkaTemplate.send(kafkaTopic, message);
    }
}
