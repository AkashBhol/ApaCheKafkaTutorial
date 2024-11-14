package com.example.Spring_Boot_Kafka_Store_DataBase.Controller;

import com.example.Spring_Boot_Kafka_Store_DataBase.KafkaService.KafkaProducer;
import com.example.Spring_Boot_Kafka_Store_DataBase.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class UserKafkaController {

    private static final Logger log = LoggerFactory.getLogger(UserKafkaController.class);

    @Autowired
    private KafkaProducer kafkaProducer;


    //url->http://localhost:8084/api/v2/post/user
    @PostMapping("/post/user")
    public ResponseEntity<String> createUserKafka(@RequestBody User  user){
        log.info("The user value :{}",user);
        kafkaProducer.kafkaPublish(user);
        return new ResponseEntity<String>("Message Sent successfully", HttpStatus.CREATED);
    }

}
