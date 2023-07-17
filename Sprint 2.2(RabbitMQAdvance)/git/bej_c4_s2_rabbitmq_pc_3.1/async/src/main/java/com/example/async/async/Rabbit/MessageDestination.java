package com.example.async.async.Rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues ="Hello")
public class MessageDestination {
    @RabbitHandler
    public void receive(String data)
    {
        System.out.println("Receiver receive data"+data);
    }
}
