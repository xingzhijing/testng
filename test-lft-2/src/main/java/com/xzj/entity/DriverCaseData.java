package com.xzj.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

@Data
@TableName(value = "lft_api_driver_data", autoResultMap = true)
public class DriverCaseData {
    private Integer id;

    //    url地址
    @TableField("api_host")
    private String apiHost;

    //    接口地址
    private String uri;

    //    请求方法
    private String post;

    //    请求参数
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject parameters;

    //    接口预期结果
    @TableField("expect_result")
    private String expectResult;

    //    接口实际结果
    @TableField("actual_result")
    private String actualResult;

    @TableField("is_run")
    //    接口是否运行  0 未运行, 1 已运行
    private String isRun;

    //    接口描述
    private String descriptions;

    @TableField("create_time")
    private String createTime;

    @TableField("update_time")
    private String updateTime;
}
