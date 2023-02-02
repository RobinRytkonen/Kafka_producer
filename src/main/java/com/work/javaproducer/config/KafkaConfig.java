package com.work.javaproducer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

//    Todo here actually chould be something like
//    @Bean
//    public NewTopic playerEventTopic() {
//        return TopicBuilder
//                .name("local.player-events")
//                .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000)) // how long you plan to keep massages in milliseconds
//                .partitions(1) // As there is only one consumer
//                .replicas(1)
//                .build();
//    }

 /*   @Bean
    public ProducerFactory<String, Player>
    producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Player>
    kafkaTemplate() {
        return new KafkaTemplate<>(
                producerFactory());
    }*/
}
