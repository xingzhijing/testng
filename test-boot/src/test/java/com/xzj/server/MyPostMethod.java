package com.xzj.server;

import com.xzj.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/")
@RequestMapping("/v1")
public class MyPostMethod {
//    存储cookie
    private static Cookie cookie;

//    登录接口
    @PostMapping (value = "/login")
    @ApiOperation(value = "登录post接口，登录成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam String username,
                        @RequestParam String password){
        if (username.equals("luka") && password.equals("123456")){
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "登录成功！";
        }
        return "登录失败";
    }

//    获取用户列表接口
    @PostMapping (value = "/user/list")
    @ApiOperation(value = "获取用户信息列表接口", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @CookieValue(name = "login", defaultValue = "false", required = false) String login,
                              @RequestBody User u){
        User user = new User();
        Cookie[] cookies = request.getCookies();
        for (Cookie c: cookies) {
            if (c.getName().equals("login")
                    && c.getValue().equals("true")
                    && u.getUsername().equals("luka")
                    && u.getPassword().equals("123456")){
                user.setUsername("jack");
                user.setPassword("123");
                return user.toString();
            }
        }
        return "禁止访问！获取信息失败！";
    }
}
