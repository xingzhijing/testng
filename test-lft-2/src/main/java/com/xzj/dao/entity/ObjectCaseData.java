package com.xzj.dao.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.util.Date;


/**
 * 测试用例实例
 * */
@Data
@TableName(value = "lft_api_case_data", autoResultMap = true)
public class ObjectCaseData {
    private Long id;

    //    url地址
    @TableField("api_host")
    private String apiHost;

//    业务数据类型
    @TableField("data_type")
    private String dataType;

    //    接口地址
    private String uri;

    //    请求方法
    private String method;

    //    请求参数
    @TableField(typeHandler = JacksonTypeHandler.class)
    private JSONObject parameters;

    //    接口实际结果
    @TableField(value = "actual_result", typeHandler = JacksonTypeHandler.class)
    private JSONObject actualResult;

    //    接口预期结果
    @TableField("expect_result")
    private String expectResult;

    @TableField("is_run")
    //    接口是否运行  0 未运行, 1 已运行
    private String isRun;

    //    接口描述
    private String descriptions;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
