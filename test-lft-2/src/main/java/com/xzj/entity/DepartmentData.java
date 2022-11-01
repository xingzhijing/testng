package com.xzj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "department_data")
public class DepartmentData {
    private Integer id;

    @TableField("company_id")
    private String companyId;

    @TableField("department_id")
    private String departmentId;

    @TableField("tax_no")
    private String taxNo;
}
