package com.ab.controller;

import com.ab.bean.Person;
import com.ab.bean.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Person person;
    @Autowired
    private Person2 person2;
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayHello(){
        System.out.println(person);
        System.out.println(person2);
        return "hello word!";
    }
}
