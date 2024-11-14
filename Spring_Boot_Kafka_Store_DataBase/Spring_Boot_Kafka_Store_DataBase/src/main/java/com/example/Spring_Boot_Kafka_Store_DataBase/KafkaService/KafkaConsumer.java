package com.example.Spring_Boot_Kafka_Store_DataBase.KafkaService;

import com.example.Spring_Boot_Kafka_Store_DataBase.Model.User;
import com.example.Spring_Boot_Kafka_Store_DataBase.Repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class KafkaConsumer {

    private static final Logger log= LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    private UserRepository userRepository;


    ArrayList<User> li=new ArrayList<>();
    @KafkaListener(topics = "demo4-event",groupId = "MyGroup")
    public void kafkaSubscribe(User user){

        li.add(user);
        if(li.size()==5){
            userRepository.saveAll(li);
            li.clear();
        }
      log.info("The Json value from consumer:{}",user);
    }
}
