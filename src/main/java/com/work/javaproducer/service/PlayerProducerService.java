package com.work.javaproducer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.work.kafka.api.RegisterPlayerDTO;
import org.work.kafka.api.WinDepositDTO;

import static com.work.javaproducer.util.Constants.DEPOSIT_TOPIC;
import static com.work.javaproducer.util.Constants.REGISTER_TOPIC;

@Service
public class PlayerProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PlayerProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ResponseEntity<String> registerPlayer(RegisterPlayerDTO registerPlayerDTO) {
        kafkaTemplate.send(REGISTER_TOPIC, registerPlayerDTO.getEmail(), registerPlayerDTO);
        return ResponseEntity.ok().body("Registered player successfully!");
    }

    public ResponseEntity<String> deposit(WinDepositDTO winDepositDTO) {
        kafkaTemplate.send(DEPOSIT_TOPIC, String.valueOf(winDepositDTO.getPlayerId()), winDepositDTO);
        return ResponseEntity.ok().body("Deposited win successfully!");
    }
}
