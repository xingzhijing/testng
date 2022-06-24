package com.xzj.get;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@Api(value = "/")
public class MyGetMethod {
    @GetMapping("/getCookies")
    @ApiOperation(value = "这是无headers 无params的get请求接口", httpMethod = "get")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "这是返回的cookies信息";
    }

    /**
     * Method: Get
     * Headers: 携带cookies访问
     * Params: null
     * */
    @GetMapping("/get/with/cookie")
    @ApiOperation(value = "这是带headers 无params的get请求接口", httpMethod = "get")
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

    /**
     * Method: Get
     * Headers: 携带cookies访问
     * Params:
     * */
    @GetMapping(value = "/get/with/{start}&{end}")
    @ApiOperation(value = "这是带headers 带params的get请求接口", httpMethod = "get")
    public Map<String, Integer> getWithParams(@PathVariable Integer start,
                                              @PathVariable Integer end){
        Map<String, Integer> map = new HashMap<>();
        map.put("喜小乐", 12);
        map.put("鸡小萌", 17);
        map.put("石敢当", 18);
        return map;
    }
}
