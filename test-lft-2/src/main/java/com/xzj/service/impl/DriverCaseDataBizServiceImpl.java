package com.xzj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzj.common.Validation;
import com.xzj.dto.ObjectCaseDTO;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.service.object.ObjectCaseDataService;
import com.xzj.service.ICompanyDataBizService;
import com.xzj.service.IDepartmentDataBizService;
import com.xzj.service.IDriverCaseDataBizService;
import com.xzj.utils.Base64Utils;
import com.xzj.utils.CreateSignUtils;
import com.xzj.utils.HttpUtils;
import com.xzj.utils.RandomStrUtils;
import com.xzj.utils.biz.BizUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DriverCaseDataBizServiceImpl implements IDriverCaseDataBizService {
    @Autowired
    ICompanyDataBizService companyDataBizService;

    @Autowired
    IDepartmentDataBizService departmentDataBizService;

    @Autowired
    ObjectCaseDataService objectCaseDataService;

    /**
     * 新增司机
     */
    @Override
    public JSONArray saveDriverCaseData(ObjectCaseDTO objectCaseDTO) throws IOException {
        Map<String, String> headersMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

//        查询集团信息——company_key, company_secret
        CompanyData companyData = companyDataBizService.getByCompanyId(objectCaseDTO.getCompanyId());
//        查询driver case
        List<ObjectCaseData> objectCaseDataList = objectCaseDataService.listByIds(objectCaseDTO.getIds(), objectCaseDTO.getDataType());

//        新增司机接口参数
        for (ObjectCaseData objectCaseData : objectCaseDataList) {
            JSONObject caseDataParameters = objectCaseData.getParameters();
            caseDataParameters.put("company_key",companyData.getCompanyKey());
            caseDataParameters.put("nonce_str", RandomStrUtils.getRandomStr(6));
            caseDataParameters.put("idCardFaceFile", Base64Utils.GetImageStr(caseDataParameters.getString("idCardFaceFile")));
            caseDataParameters.put("idCardGuohuiFile", Base64Utils.GetImageStr(caseDataParameters.getString("idCardGuohuiFile")));
            caseDataParameters.put("drivingLicenseFirstFile", Base64Utils.GetImageStr(caseDataParameters.getString("drivingLicenseFirstFile")));
            caseDataParameters.put("drivingLicenseSecondFile", Base64Utils.GetImageStr(caseDataParameters.getString("drivingLicenseSecondFile")));
            caseDataParameters.put("serviceAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("serviceAgreement")));
            caseDataParameters.put("entrustmentAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("entrustmentAgreement")));
            caseDataParameters.put("taxPaymentAgreement", Base64Utils.GetImageStr(caseDataParameters.getString("taxPaymentAgreement")));
//            添加签名
            caseDataParameters.put("sign", CreateSignUtils.invokeFee(caseDataParameters, companyData.getCompanySecret()));
            headersMap.put("Content-Type", "application/x-www-form-urlencoded");
            String url = BizUtil.IntegrateUrl(objectCaseData.getApiHost(), objectCaseData.getUri());
//            发送请求
            JSONObject jsonObject = HttpUtils.doPost(url, headersMap, caseDataParameters);
            jsonArray.add(jsonObject);
//            设置测试运行结果
            Boolean updateResult = objectCaseDataService.update(BizUtil.updateCaseData(objectCaseData.getId(), jsonObject));
//            验证逻辑
            if (updateResult){
                System.out.println("验证结果====>" + Validation.ValidationResultForCode(String.valueOf(jsonObject.get("code"))));
            }
        }
        System.out.println("jsonArray ===> " + jsonArray);

        return jsonArray;
    }

}
