package com.ab.elasticsearch;

import java.util.Set;

//  可能是版本问题，没有使用 elasticsearch starter
//@Document(indexName = "person",type = "person", replicas = 0, shards = 1)
public class Person {

//    @Id
    private String id;
    private String name;
    private Integer age;
    private Set<String> hobby;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + hobby +
                '}';
    }
}
