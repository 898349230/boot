package com.ab.rabbitmq;


import com.ab.Constants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        this.rabbitTemplate.convertAndSend(Constants.RABBITMQ_QUEUE_NAME, message);
    }
}
