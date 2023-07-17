package com.stackroute.example.RabbitMQ;

import com.stackroute.example.domain.UserDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    public void sendDTO2Queue(UserDTO userDTO)
    {
        rabbitTemplate.convertAndSend(directExchange.getName(),"user_routing",userDTO);
    }

}
