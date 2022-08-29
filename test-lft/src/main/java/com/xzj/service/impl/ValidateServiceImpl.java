package com.xzj.service.impl;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.xzj.service.ValidationService;
import org.springframework.stereotype.Service;
import org.testng.Assert;

@Service
public class ValidateServiceImpl implements ValidationService {
    @Override
    public void generalValidate(JSONObject jsonObject) throws JSONException {
        if (jsonObject != null){
            Assert.assertEquals(jsonObject.get("msg"), "成功", "返回的msg为: " + jsonObject.get("msg"));
            Assert.assertEquals(jsonObject.get("code"), 0, "返回的code码为: "+jsonObject.get("code"));
        }else {
            System.out.println("没有返回结果！");
        }
    }

}
