package com.example.ApacheKafkaTutorial.KafkaSErvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demo1-event", groupId = "MyGroup")
    public void subscribe(String message) {
        log.info("Message received successfully: {}", message);
    }
}
