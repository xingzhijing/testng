package com.xzj.mysql.controller;

import com.xzj.mysql.dto.UserDTO;
import com.xzj.mysql.entity.User;
import com.xzj.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    查询
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

//    新增
    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userService.addUser(user);
        return "成功";
    }

//    编辑
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        Long updateId = userService.updateUser(user);
        if (updateId != null){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
}
