package com.xzj.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "api_test_data_demo", autoResultMap = true)
public class CaseData implements Serializable {

    private Integer id;

    private String cid;

    private String sid;

    @TableField("company_key")
    private String companyKey;

    @TableField("company_secret")
    private String companySecret;

//    公司税号
    @TableField("tax_no")
    private String taxNo;

    //    协议类型
    private String host;

    //    接口类别 webApi, Api
    private String category;

    //    接口地址
    private String uri;

    //    请求方式 get, post, delete, put
    private String method;

    //    请求参数
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject parameters;

    //    接口描述
    private String descriptions;

    @TableField("is_run")
    //    接口是否运行  0 未运行, 1 已运行
    private String isRun;

    //    接口预期结果
    @TableField("expect_result")
    private String expectResult;

    //    接口实际结果
    @TableField("actual_result")
    private String actualResult;

    @TableField("update_time")
    private String updateTime;


}
