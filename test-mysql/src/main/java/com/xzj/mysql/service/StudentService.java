package com.xzj.mysql.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xzj.mysql.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {
    List<Student> getUser(Integer id);
}
