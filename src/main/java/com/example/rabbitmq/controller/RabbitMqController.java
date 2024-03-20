package com.example.rabbitmq.controller;

import com.example.rabbitmq.producer.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RabbitMqController {
    private final RabbitMqProducer rabbitMqProducer;

    public RabbitMqController(RabbitMqProducer rabbitMqProducer){
        this.rabbitMqProducer = rabbitMqProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to rabbitmq");

    }
}
