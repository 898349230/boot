package com.ab.listener2;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ApplicationContextInitializer需要配置在META-INF/spring.factories
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationontext) {
        System.out.println("HelloApplicationContextInitializer....Initializer...." + applicationontext);
    }
}
