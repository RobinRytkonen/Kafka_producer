package com.work.javaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.work.kafka.api.RegisterPlayerDTO;
import org.work.kafka.api.WinDepositDTO;

import static com.work.javaproducer.config.Constants.*;

@RestController
public class PlayerController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/register")
    public String registerPlayer(@RequestBody RegisterPlayerDTO registerPlayerDTO) {
        kafkaTemplate.send(REGISTER_TOPIC, registerPlayerDTO.getName(), registerPlayerDTO);
        return "Registered player successfully!";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestBody WinDepositDTO winDepositDTO) {
        kafkaTemplate.send(DEPOSIT_TOPIC, String.valueOf(winDepositDTO.getPlayerId()), winDepositDTO);
        return "Deposited Successfully";
    }


}
