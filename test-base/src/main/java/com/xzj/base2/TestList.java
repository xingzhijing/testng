package com.xzj.base2;

import java.util.ArrayList;
import java.util.Arrays;

public class TestList {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(3);
        System.out.println(arrayList);

        int[] arrays = new int[]{1, 2, 3, 4};
        System.out.println(arrays[1]);
        String[] str = new String[]{"1", "2", "3"};

    }
}
