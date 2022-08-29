package com.xzj.service;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.testng.Assert;

@Service
public interface ValidationService {

    /**
     * 通用的业务结果校验
     * @param jsonObject 返回结果
     * */
    void generalValidate(JSONObject jsonObject) throws JSONException;

//    /**
//     * 具体的业务结果校验: 需要具体实现
//     * @param jsonObject 返回结果
//     * */
//    void
//    specificValidate(JSONObject jsonObject) throws JSONException;
}
