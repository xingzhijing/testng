package com.xzj.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class JavaFeature {
    /**
     * stream集合遍历foreach
     * */
    public void StreamForEach(){
        List list = new ArrayList();
        list.add("喜小乐");
        list.add("鸡小萌");
        list.add("石敢当");
        list.stream().forEach(s-> System.out.println(s));
        list.stream().forEach(s-> {
            System.out.println(s);
            System.out.println(2);
        });
    }

    /**
     * stream 对象：遍历foreach
     * */
    public void StreamObjectForEach(){
        Student student = new Student();
        student.setName("mary");
        student.setAge(12);
        List<Student> list = new ArrayList();
        list.add(student);
        list.stream().forEach(s-> System.out.println(s.getName()));
        list.stream().forEach(s-> {
            System.out.println(s.getName());
            System.out.println(s.getAge());
        });

    }

    /**
     * stream条件过滤filter
     * */
    public void StreamFilter(){
        List list = new ArrayList();
        list.add("luka");
        list.add("jack");
        list.add(" ");
        list.stream().filter(s -> s.equals("luka")).forEach(s -> System.out.println(s));
        list.stream().filter(s -> s.equals("luka")).forEach(System.out::println);
        list.stream().filter(s -> !s.equals("")).forEach(s -> System.out.println(s));
    }

    /**
     * stream 复杂对象：条件过滤filter
     * */
    public void StreamObjectFilter(){
        Student student = new Student();
        student.setName("mary");
        student.setAge(12);
        List<Student> list = new ArrayList();
        list.add(student);
//        姓名不为空打印
        list.stream().filter(student1 -> !student1.getName().isEmpty()).forEach(student1 -> System.out.println(student1.getName()));
//        多个条件同时过滤
        list.stream().filter(student1 -> student1.getName().startsWith("m")).filter(student1 -> student1.getAge()>10).forEach(System.out::println);

    }



    /**
     * Stream映射map
     *
     * 类型转换：String流转为int流
     * */
    public void StreamStringToInt(){
        Stream<String> str = Stream.of("1", "2");
        str.map(s -> Integer.valueOf(s)).forEach(System.out::println);
    }

    /**
     * Stream映射map
     *
     * 使用map方法:用于映射每个元素到对应的结果
     * */
    public void StreamReflectMap(){
        List<Integer> strList = Arrays.asList(1, 2, 3, 4, 5);
        List list = strList.stream().map(i -> i*i).collect(Collectors.toList());
        list.forEach(s-> System.out.println(list.indexOf(s) + ":" + s));
    }

    /**
     *
     * 类型转换：转为list
     * */
    public void StreamStringToList(){
        Stream<String> str = Stream.of("1", "2");
//        转为list集合
        List strList = str.collect(Collectors.toList());
        strList.forEach(s -> System.out.println(s));
    }

    /**
     * Stream映射map
     *
     * 类型转换：转为Map
     * */
    public void StreamListToMap(){
        List<String> strList = Arrays.asList("a", "ba", "bb", "abc", "cbb", "bba", "cab");
//        转为Map集合
        Map strMap = strList.stream().collect(Collectors.toMap(s-> strList.indexOf(s), s->s));
        strMap.forEach((key, value)-> System.out.println(key + ":" + value));
    }

    /**
     * exception：stream has already been operated upon or closed
     * 解决流调用了终结方法不能重用流的问题：通过构建stream supplier来创建新流,每次调用get()方法创建新流
     * */
    public void StreamStringToList1(){
        Supplier<Stream<String>> supplier = ()-> Stream.of("1", "2");
        List strList = supplier.get().collect(Collectors.toList());
        Map map = supplier.get().collect(Collectors.toMap(s->strList.indexOf(s), s->s));
    }


    public static void main(String[] args) {
        JavaFeature javaFeature = new JavaFeature();
//        javaFeature.StreamForEach();
//        javaFeature.StreamFilter();
//        javaFeature.StreamObjectForEach();
//        javaFeature.StreamObjectFilter();
//        javaFeature.StreamReflectMap();
//        javaFeature.StreamStringToInt();
//        javaFeature.StreamStringToList();
//        javaFeature.StreamListToMap();
        javaFeature.StreamStringToList1();
    }
}
