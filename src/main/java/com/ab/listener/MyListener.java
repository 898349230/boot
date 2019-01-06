package com.ab.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义 监听器
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(" contextInitialized .... 服务器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(" contextDestroyed .... 服务器关闭");
    }
}
