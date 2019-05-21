package com.ab.controller;

import com.ab.elasticsearch.ElasticsearchService;
import com.ab.rabbitmq.RabbitMQSenderService;
import com.ab.redis.RedisService;
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
    @Autowired
    private RedisService redisService;
    @Autowired
    private ElasticsearchService elasticsearchService;

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

    /**
     * 测试 redis
     * @param key
     * @param value
     * @return
     */
    @GetMapping(value = "/redisSet")
    @ResponseBody
    public String redisSet(@RequestParam(value = "key")String key, @RequestParam(value = "value")String value){
        redisService.setString(key, value);
        return "success";
    }

    /**
     * 测试 redis
     * @param key
     * @return
     */
    @GetMapping(value = "/redisGet")
    @ResponseBody
    public String redisGet(@RequestParam(value = "key")String key){
        String str = redisService.getString(key);
        return str;
    }

    /**
     * 测试 es 增加数据
     * @return
     */
    @GetMapping(value = "/esAdd")
    @ResponseBody
    public String elastisearchPut(){
        Integer code = elasticsearchService.addPerson();
        return code.toString();
    }

    /**
     * 测试 es 获取数据
     * @return
     */
    @GetMapping(value = "/esGet")
    @ResponseBody
    public String elastisearchGet(){
        String str = elasticsearchService.getPerson();
        return str;
    }



}
