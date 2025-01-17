package com.example.ApacheKafkaTutorial.KafkaSErvice;

import com.example.ApacheKafkaTutorial.Payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {

    public static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demo4-event", groupId = "MyGroup")
    public void subscribe(User user) {
        log.info("message recived successfully:{}", user);
    }
}
