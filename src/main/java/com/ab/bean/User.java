package com.ab.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//  使用JPA注解配置映射关系
//  告诉JPA 这是一个实体类
@Entity
// 指定表名， 默认是类名小写 user
@Table(name = "tbl_user")
public class User {

    @Id // 主键
    @GenericGenerator(name="idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;
    @Column(name = "last_name", length = 50)
    private String lastName;
    @Column // 默认列名救赎属性名
    private String email;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
