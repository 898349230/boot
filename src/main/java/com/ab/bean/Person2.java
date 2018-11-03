package com.ab.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * prefix = "person2"：配置文件中哪个下面的所有属性进行一一映射
 * *
只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 * @ConfigurationProperties(prefix = "person2")默认从全局配置文件中获取值；
 *
 */
// 指定配置文件位置
@PropertySource(value = {"classpath:person2.properties"})
@Component
@ConfigurationProperties(prefix = "person2")
public class Person2 {
//    @Value(value = "${person2.lastName}")
    private String lastName;
//    @Value(value = "${person2.age}")
    protected Integer age;
//    @Value(value = "${person2.birth}")
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    /** 映射 str 值为 abc */
    @Value(value = "abc")
    private String str;
    @Value(value = "#{3*6}")
    private Integer height;
    /** 后去配置文件中的变量 */
    @Value(value = "${hobby}")
    private String hobby;
    /** 读取applicat.yml 文件中的值 */
    @Value(value = "${person.age}")
    private String personAge;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person2{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                ", str='" + str + '\'' +
                ", height=" + height +
                ", hobby='" + hobby + '\'' +
                ", personAge='" + personAge + '\'' +
                '}';
    }
}
