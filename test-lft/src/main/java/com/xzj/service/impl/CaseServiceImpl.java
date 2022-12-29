package com.xzj.service.impl;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xzj.entity.CaseData;
import com.xzj.log.LogConfig;
import com.xzj.mapper.CaseMapper;
import com.xzj.service.CaseService;
import com.xzj.service.CreateSignService;
import com.xzj.service.IntegrationService;
import com.xzj.service.ValidationService;
import com.xzj.utils.Base64Utils;
import com.xzj.utils.HttpUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper,CaseData> implements CaseService {
    @Autowired
    CaseMapper caseMapper;

    @Autowired
    CreateSignService createSignService;

    @Autowired
    ValidationService validationService;

    Logger logger = (Logger) LoggerFactory.getLogger(LogConfig.class);

    @Override
    public List<CaseData> getCaseListByCondition(Integer id) {
        LambdaQueryWrapper<CaseData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(CaseData::getId, id);
        List<CaseData> caseDataList = caseMapper.selectList(lambdaQueryWrapper);
        return caseDataList;
    }

    @Override
    public JSONArray getCaseListByParam(String protocol) throws IOException {
        LambdaQueryWrapper<CaseData> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        LambdaUpdateChainWrapper<CaseData> lambdaUpdateChainWrapper = new LambdaUpdateChainWrapper<>(caseMapper);
        lambdaQueryWrapper.eq(CaseData::getHost, protocol);
//        查询测试数据
        List<CaseData> caseDataList = caseMapper.getCaseListByParam(lambdaQueryWrapper);
        JSONArray jsonArray = new JSONArray();
        for (CaseData caseData : caseDataList) {
//            测试用例业务参数
            JSONObject caseDataParameters = caseData.getParameters();
            LambdaUpdateChainWrapper<CaseData> lambdaUpdateChainWrapper = new LambdaUpdateChainWrapper<>(caseMapper);
//            请求url
            String interfaceUrl = caseData.getHost() + caseData.getUri();
//            请求体参数
            Map<String, Object> params = new HashMap<>();
            Map<String, String> headers = new HashMap<>();

//           参数设置
            params.put("taxno", caseData.getTaxNo());
            params.put("company_key", caseData.getCompanyKey());
            params.put("driverName", caseDataParameters.getString("driverName"));
            params.put("sex", caseDataParameters.getString("sex"));
            params.put("phoneNum", caseDataParameters.getString("phoneNum"));
            params.put("idCard", caseDataParameters.getString("idCard"));
            params.put("idCardEffectwStart", caseDataParameters.getString("idCardEffectStart"));
            params.put("idCardEffectEnd", caseDataParameters.getString("idCardEffectEnd"));
            params.put("idCardFaceFile", Base64Utils.GetImageStr(caseDataParameters.getString("idCardFaceFile")));
            params.put("idCardGuohuiFile", Base64Utils.GetImageStr(caseDataParameters.getString("idCardGuohuiFile")));
            params.put("bankAccount", caseDataParameters.getString("bankAccount"));
            params.put("bankAccountName", caseDataParameters.getString("bankAccountName"));
            params.put("bank", caseDataParameters.getString("bank"));
            params.put("drivingLicenseFirstFile", Base64Utils.GetImageStr(caseDataParameters.getString("drivingLicenseFirstFile")));
            params.put("drivingLicenseSecondFile", Base64Utils.GetImageStr(caseDataParameters.getString("drivingLicenseSecondFile")));
            params.put("drivingLicenseFirstEffect", caseDataParameters.getString("drivingLicenseFirstEffect"));
            params.put("drivingLicenseEffectDate", caseDataParameters.getString("drivingLicenseEffectDate"));
            params.put("drivingLicenseNo", caseDataParameters.getString("drivingLicenseNo"));
            params.put("drivingLicenseType", caseDataParameters.getString("drivingLicenseType"));
            params.put("NVQEffectDate", caseDataParameters.getString("NVQEffectDate"));
            params.put("NVQNo", caseDataParameters.getString("NVQNo"));
            params.put("state", caseDataParameters.getString("state"));
            params.put("serviceAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("serviceAgreement")));
            params.put("entrustmentAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("entrustmentAgreement")));
            params.put("taxPaymentAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("taxPaymentAgreement")));
            params.put("sign", createSignService.invokeFee(params, caseData.getCompanySecret()));
//          请求头设置
            headers.put("Content-Type", "application/x-www-form-urlencoded");
//          设置后不校验签名
//            headers.put("twgdh", "xjdmg");
            JSONObject jsonObject = HttpUtils.doPost(interfaceUrl, headers, params);
//            jsonObject.put("id", caseData.getId());
//            测试用例执行过后更新字段：
//              1. 将数据库的is_run字段为1；
//              2. 将实际结果更新到数据库的actual_result
//              3. 更新update_time
//            caseMapper.updateCaseRunState(lambdaQueryWrapper);
            lambdaUpdateChainWrapper.eq(CaseData::getId, caseData.getId())
                    .set(CaseData::getIsRun, "1")
                    .set(CaseData::getActualResult, jsonObject.toString())
                    .set(CaseData::getUpdateTime, new Date())
                    .update(caseData);
//          开始结果校验
            try {
                validationService.generalValidate(jsonObject);
            }catch (AssertionError assertionError){
                logger.info("===========" + assertionError);
            }finally {
                System.out.println(jsonObject);
            }
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

}
