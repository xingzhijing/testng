package com.xzj.get;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class MyGetMethod {
    @GetMapping(value = "/getCookies")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "这是返回的cookies信息";
    }

    @GetMapping("/get/with/cookie")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "请携带cookie访问";
        }else {
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                    return "携带cookie的请求访问成功!";
                }
            }
        }
        return "请携带cookie访问";
    }
}
