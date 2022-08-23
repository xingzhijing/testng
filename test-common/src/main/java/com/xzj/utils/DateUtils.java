package com.xzj.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    /**
     * 格式化时间
     * @param date 时间
     * @param formatPattern 想要的日期格式
     * */
    public static String localDateFormat(LocalDate date, String formatPattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return date.format(formatter);
    }

    public static String localDateTimeFormat(LocalDateTime dateTime, String formatPattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return dateTime.format(formatter);
    }
}
