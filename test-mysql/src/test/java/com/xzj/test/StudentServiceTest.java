package com.xzj.test;

import com.xzj.mysql.DemoApplication;
import com.xzj.mysql.entity.Student;
import com.xzj.mysql.service.StudentService;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = DemoApplication.class)
public class StudentServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    StudentService studentService;

    @Test
    public void getUserTest(){
        List<Student> studentList = studentService.getUser(1);
        System.out.println(studentList);
    }

}
