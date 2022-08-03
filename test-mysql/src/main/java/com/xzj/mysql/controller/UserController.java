package com.xzj.mysql.controller;

import com.xzj.common.Result;
import com.xzj.mysql.dto.UserDTO;
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
    @GetMapping("/find/{userId}")
    public UserDTO getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

//    新增用户
    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO user){
        userService.addUser(user);
        return "成功";
    }

//    编辑用户
    @PutMapping("/update/{userId}")
    public Result<Boolean> updateUser(@PathVariable String userId, @RequestBody UserDTO user){
        // TODO
        //  1. userId 非空校验, 校验当前用户是否存在， 设置参数user.setUserId(userId)
        //  2. 校验待更新信息非空
//        判断userId是否为空
        if (StringUtils.hasText(userId)){
//            判断userId是否存在
            UserDTO userDTO = userService.getUser(Long.valueOf(userId));
            if (userDTO != null){
                user.setId(Long.valueOf(userId));
//                修改用户信息
                Long updateId = userService.updateUser(user);
                if (StringUtils.hasText(String.valueOf(updateId))){
                    return Result.succeed(true);
                }else {
                    return Result.fail("-1", "修改失败");
                }
            }else {
                return Result.fail("-1", "没有查询到用户信息");
            }
        }else {
            return Result.fail("-1", "用户ID不能为空");
        }
    }

    @DeleteMapping("/delete/{userId}")
    public Result<Boolean> deleteUserById(@PathVariable String userId){
//        判断userId是否为空
        if (StringUtils.hasText(userId)){
//            判断userId是否存在
            UserDTO userDTO = userService.getUser(Long.valueOf(userId));
            if (userDTO != null){
                Long deleteId = userService.deleteUserById(Long.valueOf(userId));
                if (StringUtils.hasText(String.valueOf(deleteId))){
                    return Result.succeed(true);
                }else {
                    return Result.fail("- 1", "删除失败");
                }
            }else {
                return Result.fail("-1", "没有查询到用户信息");
            }
        }else {
            return Result.fail("-1", "用户ID不能为空");
        }
    }
}
