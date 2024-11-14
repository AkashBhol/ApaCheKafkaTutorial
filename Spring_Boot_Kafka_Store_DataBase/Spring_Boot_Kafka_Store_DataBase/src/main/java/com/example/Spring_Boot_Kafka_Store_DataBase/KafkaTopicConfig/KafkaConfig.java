package com.example.Spring_Boot_Kafka_Store_DataBase.KafkaTopicConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name("demo4-event")
//           .partitions(10)
                .build();
    }
}
