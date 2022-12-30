package com.example.block12kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerKafka2 {

    @KafkaListener(topics = "topic", groupId = "group_id")
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
