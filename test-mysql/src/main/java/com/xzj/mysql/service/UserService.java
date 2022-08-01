package com.xzj.mysql.service;


import com.xzj.mysql.dto.UserDTO;
import com.xzj.mysql.entity.User;

public interface UserService {

    UserDTO getUser(Long userId);

    Long addUser(UserDTO user);

    Long updateUser(UserDTO user);

    UserDTO getUserByBizId(String bizId);
}
