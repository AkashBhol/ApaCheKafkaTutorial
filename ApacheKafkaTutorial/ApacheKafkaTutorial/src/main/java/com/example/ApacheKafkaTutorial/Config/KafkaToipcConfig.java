package com.example.ApacheKafkaTutorial.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

public class KafkaToipcConfig {


    @Bean
    public NewTopic javaGuideTopics(){
        return TopicBuilder.name("demo4-event")
//                .partitions(10)
                .build();
    }
}
