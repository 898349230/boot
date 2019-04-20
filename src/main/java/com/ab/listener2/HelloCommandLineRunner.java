package com.ab.listener2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

/**
 * CommandLineRunner 需要放在容器中
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("HelloCommandLineRunner...run..." + Arrays.asList(args));
    }
}
