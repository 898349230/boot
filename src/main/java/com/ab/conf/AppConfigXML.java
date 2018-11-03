package com.ab.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Configuration：指明当前类是一个配置类
 * 在配置文件中用<bean><bean/>标签添加组件
 *
 */
@Configuration

/** 加载指定的 xml 配置文件
 * 启动日志  --> [           main] o.s.b.f.xml.XmlBeanDefinitionReader      : Loading XML bean definitions from class path resource [spring/beans.xml]
 * */
//@ImportResource(value = "classpath:/spring/beans.xml")
public class AppConfigXML {

}
