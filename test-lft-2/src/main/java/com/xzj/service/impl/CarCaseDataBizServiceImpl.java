package com.xzj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzj.common.Validation;
import com.xzj.dao.entity.CompanyData;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.service.object.ObjectCaseDataService;
import com.xzj.dto.ObjectCaseDTO;
import com.xzj.service.ICarCaseDataBizService;
import com.xzj.service.ICompanyDataBizService;
import com.xzj.utils.Base64Utils;
import com.xzj.utils.CreateSignUtils;
import com.xzj.utils.HttpUtils;
import com.xzj.utils.RandomStrUtils;
import com.xzj.utils.biz.BizUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarCaseDataBizServiceImpl implements ICarCaseDataBizService {
    @Autowired
    ICompanyDataBizService companyDataBizService;

    @Autowired
    ObjectCaseDataService objectCaseDataService;
    @Override
    public JSONArray saveCarCaseData(ObjectCaseDTO objectCaseDTO) throws IOException {
        Map<String, String> headersMap = new HashMap<>();
        JSONArray jsonArray = new JSONArray();

//        查询集团信息——company_key, company_secret
        CompanyData companyData = companyDataBizService.getByCompanyId(objectCaseDTO.getCompanyId());

        List<ObjectCaseData> objectCaseDataList = objectCaseDataService.listByIds(objectCaseDTO.getIds(), objectCaseDTO.getDataType());
//        接口参数
        for (ObjectCaseData objectCaseData: objectCaseDataList) {
            JSONObject caseDataParameters = objectCaseData.getParameters();
            caseDataParameters.put("company_key", companyData.getCompanyKey());
            caseDataParameters.put("nonce_str", RandomStrUtils.getRandomStr(6));
            caseDataParameters.put("vehicleLicenseFirstFile", Base64Utils.GetImageStr(caseDataParameters.getString("vehicleLicenseFirstFile")));
            caseDataParameters.put("vehicleLicenseSecondFile", Base64Utils.GetImageStr(caseDataParameters.getString("vehicleLicenseSecondFile")));
            caseDataParameters.put("roadTransportPermitFile", Base64Utils.GetImageStr(caseDataParameters.getString("roadTransportPermitFile")));
//            签名
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
        return jsonArray;
    }
}
