package com.example.ApacheKafkaTutorial.KafkaSErvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private static  final Logger log= LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("message sent %s",message));
        kafkaTemplate.send("demo1-event",message);
    }
}
