package com.ab.controller;

import com.ab.rabbitmq.RabbitMQSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;
    /**
     * 测试 发送rabbitMQ消息
     * @param message
     * @return
     */
    @GetMapping(value = "/rabbitSend")
    @ResponseBody
    public String rabbitSend(@RequestParam(value = "message")String message){
        rabbitMQSenderService.sendMessage(message);
        return "success";
    }
}
