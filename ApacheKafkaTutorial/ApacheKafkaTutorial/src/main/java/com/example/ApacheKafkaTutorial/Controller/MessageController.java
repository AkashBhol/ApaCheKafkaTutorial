package com.example.ApacheKafkaTutorial.Controller;

import com.example.ApacheKafkaTutorial.KafkaSErvice.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
public class MessageController {

    @Autowired
    private KafkaProducer  kafkaProducer;

    //url->http://localhost:7777/api/v2/publish?message=hellow word
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return new ResponseEntity<>("Message sent successfuly", HttpStatus.OK);
    }
}
