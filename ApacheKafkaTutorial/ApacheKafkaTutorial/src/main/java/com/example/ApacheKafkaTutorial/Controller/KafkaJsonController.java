package com.example.ApacheKafkaTutorial.Controller;

import com.example.ApacheKafkaTutorial.KafkaSErvice.KafkaJsonProducer;
import com.example.ApacheKafkaTutorial.Payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaJsonController {

    @Autowired
    private static  final Logger log= LoggerFactory.getLogger(KafkaJsonController.class);

    @Autowired
    private KafkaJsonProducer kafkaJsonProducer;

    //url->http://localhost:7777/api/kafka/user/publish
    @PostMapping("/user/publish")
    public ResponseEntity<String> publishUser(@RequestBody User user){
        kafkaJsonProducer.userpublish(user);
        return new ResponseEntity<>("Message sentSuccessfully", HttpStatus.OK);
    }
}
