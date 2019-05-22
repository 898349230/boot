package com.ab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class HelloService {

    private static Logger logger = LoggerFactory.getLogger(HelloService.class);

    public void hello(){
        logger.debug("~~~~~~~~~~~~~~~~~~~ service debug....");
        logger.info("~~~~~~~~~~~~~~~~~~~ service info....");
    }

}
