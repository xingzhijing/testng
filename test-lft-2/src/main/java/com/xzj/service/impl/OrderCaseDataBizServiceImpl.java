package com.xzj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xzj.common.Validation;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.service.object.ObjectCaseDataService;
import com.xzj.dto.ObjectCaseDTO;
import com.xzj.service.ICompanyDataBizService;
import com.xzj.service.IOrderCaseDataBizService;
import com.xzj.utils.*;
import com.xzj.utils.biz.BizUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class OrderCaseDataBizServiceImpl implements IOrderCaseDataBizService {
    @Autowired
    ICompanyDataBizService companyDataBizService;

    @Autowired
    ObjectCaseDataService objectCaseDataService;

    @Override
    public JSONArray saveOrderCaseData(ObjectCaseDTO objectCaseDTO) throws IOException {
//        Map<String, Object> orderCaseParamsMap = new HashMap<>();
        Map<String, String> headersMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

//        查询集团信息——company_key, company_secret
        CompanyData companyData = companyDataBizService.getByCompanyId(objectCaseDTO.getCompanyId());
        List<ObjectCaseData> objectCaseDataList = objectCaseDataService.listByIds(objectCaseDTO.getIds(), objectCaseDTO.getDataType());

//        循环查询的测试数据
        for (ObjectCaseData objectCaseData: objectCaseDataList) {
            JSONObject caseDataParameters = objectCaseData.getParameters();
            caseDataParameters.put("company_key", companyData.getCompanyKey());
            caseDataParameters.put("nonce_str", RandomStrUtils.getRandomStr(6));
//            运输合同附件
            caseDataParameters.put("protocolFileFile", Base64Utils.GetImageStr(caseDataParameters.getString("protocolFileFile")));
            caseDataParameters.put("payItems", OrderCaseDataBizServiceImpl.payInfo(JSON.parseObject(caseDataParameters.getString("payItems"), new TypeReference<List<JSONObject>>(){})));
//            签名
            caseDataParameters.put("sign", CreateSignUtils.invokeFee(caseDataParameters, companyData.getCompanySecret()));
//            拼接请求地址
            String url = BizUtil.IntegrateUrl(objectCaseData.getApiHost(), objectCaseData.getUri());
//            发送请求
            headersMap.put("Content-Type", "application/x-www-form-urlencoded");
            JSONObject jsonObject = HttpUtils.doPost(url, headersMap, caseDataParameters);
            jsonArray.add(jsonObject);
//            设置测试运行结果
            Boolean updateResult = objectCaseDataService.update(BizUtil.updateCaseData(objectCaseData.getId(), jsonObject));
//            验证结果
            if (updateResult){
                System.out.println("验证结果====>" + Validation.ValidationResultForCode(String.valueOf(jsonObject.get("code"))));
            }
        }
        return jsonArray;
    }


    /**
     * 流水信息
     * */
    public static String payInfo(List<JSONObject> payArrayList){
        List<Map> payList = new ArrayList<>();
        for (int i = 0; i < payArrayList.size(); i++) {
            JSONObject payJsonObject = payArrayList.get(i);
            payJsonObject.put("bankReceiptFile", Base64Utils.GetImageStr(payJsonObject.getString("bankReceiptFile")));
            payList.add(payJsonObject);
        }
        return JSON.toJSONString(payList);
    }
}
