package com.work.javaproducer.controller;

import com.work.javaproducer.service.PlayerProducerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.work.kafka.api.RegisterPlayerDTO;
import org.work.kafka.api.WinDepositDTO;

import static com.work.javaproducer.util.Constants.DEPOSIT_TOPIC;
import static com.work.javaproducer.util.Constants.REGISTER_TOPIC;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlayerProducerTest {

    @Mock
    KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    PlayerProducerService playerProducerService;

    @Test
    void should_send_register_player_dto_topic() {

        //given
        RegisterPlayerDTO dto = new RegisterPlayerDTO("Bob12", "Bobzoor@gmail.com123", 0);
        when(kafkaTemplate.send(REGISTER_TOPIC, dto.getEmail(), dto)).thenReturn(null);

        //when
        playerProducerService.registerPlayer(dto);

        //then
        verify(kafkaTemplate, times(1)).send(REGISTER_TOPIC, dto.getEmail(), dto);
    }

    @Test
    void should_send_deposit_dto_topic() {

        //given
        WinDepositDTO dto = new WinDepositDTO(1,500);
        when(kafkaTemplate.send(DEPOSIT_TOPIC, String.valueOf(dto.getPlayerId()), dto)).thenReturn(null);

        //when
        playerProducerService.deposit(dto);

        //then
        verify(kafkaTemplate, times(1)).send(DEPOSIT_TOPIC, String.valueOf(dto.getPlayerId()), dto);
    }
}
