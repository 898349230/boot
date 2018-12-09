package com.ab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class HelloService {

    private static Logger logger = LoggerFactory.getLogger(HelloService.class);

    public void hello(){
        logger.debug("~~~~~~~~~~~~~~~~~~~ service debug....");
        logger.info("~~~~~~~~~~~~~~~~~~~ service info....");
    }

}
