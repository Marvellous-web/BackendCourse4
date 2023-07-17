package com.example.async.async.Rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;



public class MessageSource {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        String message="Hello";
        rabbitTemplate.convertAndSend(queue.getName(),message);
        System.out.println("Sender mess"+message);
    }




}
