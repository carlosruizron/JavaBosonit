package com.example.block12kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = "topic2", groupId = "group_id")
    public void consumerMessage(String message) {
        System.out.println(message);
    }
}
