package com.xzj.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class TestData {
    private Integer id;

//    协议类型
    private String protocol;

//    接口类别 webApi, Api
    private String category;

//    接口地址
    private String uri;

//    请求方式 get, post, delete, put
    private String methods;

//    请求参数
//    private JSONObject parameters;
    private String parameters;

//    接口描述
    private String descriptions;

//    接口是否运行  0 未运行, 1 已运行
    private String isRun;

//    接口预期结果
    private String expectResult;

//    接口实际结果
    private String actualResult;
}
