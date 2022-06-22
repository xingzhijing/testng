package com.xzj.base1.test;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
public class Test2 {
    public static void main(String[] args) {
        String[][] str = new String[][]{
                {"David", "3", "Ceviche"},
                {"Corina", "10", "Beef Burrito"},
                {"David", "3", "Fried Chicken"},
                {"Carla", "5", "Water"},
                {"Carla", "5", "Ceviche"},
                {"Rous", "3", "Ceviche"}
        };
//        List<List<String>> lists = new ArrayList();
//        for (String[] str1:str){
//            lists.add(new ArrayList(Arrays.asList(str1)));
//        }
        String[] strings = str[0];
        System.out.println(Arrays.toString(Arrays.stream(strings).toArray()));
//        for (String[] str1:str){
//            System.out.println(str1);
//            for (String value: str1){
//                System.out.println(value);
//            }
//            lists.add(new ArrayList(Arrays.asList(str1)));
//        }

//        System.out.println(lists);
    }
}
