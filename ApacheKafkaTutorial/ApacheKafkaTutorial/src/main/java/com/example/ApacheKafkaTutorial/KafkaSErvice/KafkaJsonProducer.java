package com.example.ApacheKafkaTutorial.KafkaSErvice;

import com.example.ApacheKafkaTutorial.Payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;


    public void userpublish(User user) {
        log.info("The Json value is:{}", user);
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "demo4-event")
                .build();

        kafkaTemplate.send(message);
    }
}
