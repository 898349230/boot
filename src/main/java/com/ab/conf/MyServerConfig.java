package com.ab.conf;

import com.ab.filter.MyFilter;
import com.ab.listener.MyListener;
import com.ab.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册Servlet三大组建
 */
@Configuration
public class MyServerConfig {

    /**
     * 注册 自定义Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet(){
        ServletRegistrationBean<MyServlet> myServlet = new ServletRegistrationBean<>();
        myServlet.setServlet(new MyServlet());
        myServlet.addUrlMappings("/myServlet");
        return myServlet;
    }

    /**
     * 注册 自定义Filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<MyFilter> myFilter(){
        FilterRegistrationBean<MyFilter> myFilter = new FilterRegistrationBean<>();
        myFilter.setFilter(new MyFilter());
        myFilter.addUrlPatterns("/login", "/myServlet");
        return myFilter;
    }

    /**
     * 自定义 listener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<MyListener> myListenr(){
        ServletListenerRegistrationBean<MyListener> myListner = new ServletListenerRegistrationBean<>();
        myListner.setListener(new MyListener());
        return myListner;
    }

}
