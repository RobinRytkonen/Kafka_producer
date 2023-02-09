package com.work.javaproducer.controller;

import com.work.javaproducer.service.PlayerProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.work.kafka.api.RegisterPlayerDTO;
import org.work.kafka.api.WinDepositDTO;

@RestController
public class PlayerController {

    PlayerProducerService playerProducerService;

    public PlayerController(PlayerProducerService playerProducerService) {
        this.playerProducerService = playerProducerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerPlayer(@RequestBody RegisterPlayerDTO registerPlayerDTO) {
        return playerProducerService.registerPlayer(registerPlayerDTO);
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody WinDepositDTO winDepositDTO) {
        return playerProducerService.deposit(winDepositDTO);
    }
}
