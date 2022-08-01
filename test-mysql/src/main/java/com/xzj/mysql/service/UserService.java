package com.xzj.mysql.service;


import com.xzj.mysql.dto.UserDTO;
import com.xzj.mysql.entity.User;

public interface UserService {

    UserDTO getUser(Long userId);

    Long addUser(User user);

    Long updateUser(User user);
}
