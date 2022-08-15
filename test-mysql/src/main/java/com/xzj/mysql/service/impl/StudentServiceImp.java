package com.xzj.mysql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.mysql.entity.Student;
import com.xzj.mysql.mapper.StudentMapper;
import com.xzj.mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getUser(Integer id) {
        LambdaQueryWrapper<Student> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Student::getId, id);
        List<Student> studentList = studentMapper.selectList(lambdaQueryWrapper);
        return studentList;
    }
}
