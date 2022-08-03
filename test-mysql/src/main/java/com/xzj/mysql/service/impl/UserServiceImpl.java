package com.xzj.mysql.service.impl;

import com.xzj.mysql.dto.UserDTO;
import com.xzj.mysql.entity.User;
import com.xzj.mysql.mapper.UserMapper;
import com.xzj.mysql.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUser(Long userId) {
        User user = userMapper.findUserById(userId);
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    @Override
    public Long addUser(UserDTO dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userMapper.insertUser(user);
        return dto.getId();
    }

    @Override
    public Long updateUser(UserDTO dto){
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userMapper.updateUser(user);
        return dto.getId();
    }

    @Override
    public Long deleteUserById(Long userId) {
        return userMapper.deleteUserById(userId);
    }
}
