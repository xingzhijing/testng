package com.xzj.mysql.mapper;

import com.xzj.mysql.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void insertUser(User user);

    User findUserById(long id);

    Long updateUser(User user);
}
