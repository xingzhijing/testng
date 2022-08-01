package com.xzj.mysql.controller;

import com.xzj.common.Result;
import com.xzj.mysql.dto.UserDTO;
import com.xzj.mysql.entity.User;
import com.xzj.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    查询
    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping
    public UserDTO getUser(@RequestParam("bizId") String bizId) {
        return userService.getUserByBizId(bizId);
    }

//    新增
    @PostMapping
    public String addUser(@RequestBody UserDTO user){
        userService.addUser(user);
        return "成功";
    }

//    编辑
    @PutMapping("/{userId}")
    public Result<Boolean> updateUser(@PathVariable String userId, @RequestBody UserDTO user){
        // TODO
        //  1. userId 非空校验, 校验当前用户是否存在， 设置参数user.setUserId(userId)
        //  2. 校验待更新信息非空


        Long updateId = userService.updateUser(user);
        if (updateId != null){
            return Result.succeed(true);
        }else {
            return Result.fail("-1", "修改失败");
        }
    }
}
