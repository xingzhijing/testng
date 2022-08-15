package com.xzj.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    @TableField("id")
    private Integer id;

    @TableField("s_name")
    private String name;

    @TableField("s_class_name")
    private String className;

    @TableField("s_course")
    private String course;
}
