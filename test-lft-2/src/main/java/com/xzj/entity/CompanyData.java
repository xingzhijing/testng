package com.xzj.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "company_data")
public class CompanyData {
    private Integer id;

    @TableField("company_id")
    private String companyId;

    @TableField("company_key")
    private String companyKey;

    @TableField("company_secret")
    private String companySecret;
}
