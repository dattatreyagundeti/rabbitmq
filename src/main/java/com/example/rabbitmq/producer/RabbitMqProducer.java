package com.example.rabbitmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Slf4j
public class RabbitMqProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;


    // injecting rabbittemplate s-4
    private RabbitTemplate rabbitTemplate;

    public RabbitMqProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void  sendMessage(String message){
        log.info("kkk");
        log.info(String.format("Message -> %s", message));
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }

}
