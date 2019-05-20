package com.ab.listener;

import com.ab.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = {Constants.RABBITMQ_QUEUE_NAME})
    public void process2(String msg){
        System.out.println("~~~~~~~~~~  RabbitMQ2 : " + msg + " ~~~~~~~~~~~~~~~~~~~~");
    }

}
