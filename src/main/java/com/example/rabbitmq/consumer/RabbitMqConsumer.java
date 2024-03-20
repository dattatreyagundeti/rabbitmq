package com.example.rabbitmq.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consumeMessage(String message){
        log.info(String.format("recieved message -> %s", message));
    }
}
