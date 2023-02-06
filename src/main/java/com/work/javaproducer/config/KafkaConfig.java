package com.work.javaproducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.work.javaproducer.util.Constants.DEPOSIT_TOPIC;
import static com.work.javaproducer.util.Constants.REGISTER_TOPIC;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic registerPlayerTopic() {
        return TopicBuilder
                .name(REGISTER_TOPIC)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(10000))
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic depositWinTopic() {
        return TopicBuilder
                .name(DEPOSIT_TOPIC)
                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(10000))
                .partitions(1)
                .replicas(1)
                .build();
    }
}
