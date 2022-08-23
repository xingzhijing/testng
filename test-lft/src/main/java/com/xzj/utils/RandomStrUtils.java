package com.xzj.utils;

import org.springframework.lang.NonNull;

import java.util.Random;

public class RandomStrUtils {

    /**
     * 生成6位 字母和数字混合的随机数
     * */
    public static String getRandomStr(Integer len){
        String source = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int j = 0; j < len; j++) {
            rs.append(source.charAt(r.nextInt(62)));
        }
        return rs.toString();
    }

    /**
     * @param len 随机数的位数
     * 生成len位随机数字
     * */
    public static String getRandomSixInt(@NonNull Integer len){
        if (len > 0){
            return String.valueOf((int) ((Math.random()*9+1) * Math.pow(10, len-1)));
        }else {
            System.out.println("len必须是大于0的的整数");
            return "";
        }
    }
}
