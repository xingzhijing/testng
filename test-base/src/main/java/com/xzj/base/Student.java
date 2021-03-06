package com.xzj.base;

import lombok.ToString;

//ToString 默认生成toString()方法
@ToString
public class Student {
    private String name;
    private int age;

    public Student(){
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
