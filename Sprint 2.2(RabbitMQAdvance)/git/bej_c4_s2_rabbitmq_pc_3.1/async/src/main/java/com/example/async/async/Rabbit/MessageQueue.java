package com.example.async.async.Rabbit;


import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Profile("myqueue")
public class MessageQueue {
    @Bean
    public Queue getQueue(){
        return new Queue("Hello");
    }
    @Bean
    @Profile("source")
    public MessageSource getMessageSource()
    {
        return new MessageSource();
    }
    @Bean
    @Profile("destination")
    public MessageDestination getMessageDestination()
    {
        return new MessageDestination();
    }

}
