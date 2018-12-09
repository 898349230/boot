package com.ab.conf;

import com.ab.interceptors.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("~~~~~~~~~~~~~~~~ 添加拦截器 ~~~~~~~");
//      拦截请求路路径           不拦截那些请求
        registry.addInterceptor(new LoginInterceptor()).
                excludePathPatterns("/success", "/hello").
                excludePathPatterns("/asserts/**", "/webjars/**").
                excludePathPatterns("/user/login", "/","/index.html");
    }
}
