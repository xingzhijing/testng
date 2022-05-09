package com.xzj.reflect;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
//        Class cls = String.class;
//        System.out.println(cls.getName());
//        System.out.println(cls.getConstructor());
//        System.out.println(cls.getAnnotations());
//        实例化对象方式一：
//        Class cls = Class.forName("com.xzj.reflect.Person");
//        实例化对象方式二：
        Class cls = Person.class;
        System.out.println(cls.getName());
    }
}
