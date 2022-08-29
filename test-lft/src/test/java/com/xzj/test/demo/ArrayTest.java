package com.xzj.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "18");
        map.put("sex", 1);
        LinkedHashMap<String, Object> map2 = new LinkedHashMap<>();
        map2.put("name", "lisi");
        map2.put("age", "26");
        map2.put("sex", 0);

        List<LinkedHashMap<String, Object>> result = new ArrayList<>();
        result.add(map);
        result.add(map2);

        Object[][] objects = new Object[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            objects[i] = new Object[]{result.get(i)};
        }
        System.out.println(Arrays.deepToString(objects));
    }
}
