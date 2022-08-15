package com.xzj.mysql.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class StudentUTO {
    @TableField("s_id")
    private Integer id;

    @TableField("s_name")
    private String name;

    @TableField("s_class_name")
    private String className;

    @TableField("s_course")
    private String course;

}
