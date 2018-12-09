package com.ab.conf;

import com.ab.component.MyLocalResovlver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ViewConfig implements WebMvcConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(ViewConfig.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        logger.info("~~~~~~~~~~~~~~~~ 设置视图 ~~~~~~~~~");
        //浏览器发送 /  请求来到 index
//        registry.addViewController("/").setViewName("index");
        //浏览器发送 login  请求来到 login
        registry.addViewController("login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public MyLocalResovlver localResovlver(){
        return new MyLocalResovlver();
    }

}
