package com.xzj.api;

import com.alibaba.fastjson.JSONObject;
import com.xzj.LFTApplication;
import com.xzj.config.TestProperties;
import com.xzj.dto.Driver;
import com.xzj.params.DriverParams;
import com.xzj.service.IntegrationService;
import com.xzj.service.CreateSignService;
import com.xzj.utils.Base64Utils;
import com.xzj.utils.DateUtils;
import com.xzj.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.xzj.config.InterfaceName.*;

@Component
@SpringBootTest(classes = LFTApplication.class)
public class DriverOperator extends AbstractTestNGSpringContextTests {
    @Autowired
    TestProperties testProperties;
    @Autowired
    IntegrationService integrationService;
    @Autowired
    CreateSignService createSignService;

    @Test(dataProvider = "createDriverProvider", dataProviderClass = DriverParams.class)
    public void CreateDriver(Driver driver) throws Exception {
        String interfaceUrl = integrationService.integrationUrl(DRIVER_CREATE);
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        params.put("taxno", driver.getTaxNo());
        params.put("driverName", driver.getDriverName());
        params.put("sex", driver.getSex());
        params.put("phoneNum", driver.getPhoneNum());
        params.put("idCard", driver.getIdCard());
        params.put("idCardEffectStart", driver.getIdCardEffectStart());
        params.put("idCardEffectEnd", driver.getIdCardEffectEnd());
        params.put("idCardFaceFile", driver.getIdCardFaceFile());
        params.put("idCardGuohuiFile", driver.getIdCardGuohuiFile());
        params.put("bankAccount", driver.getBankAccount());
        params.put("bankAccountName", driver.getBankAccountName());
        params.put("bank", driver.getBank());
        params.put("drivingLicenseFirstFile", driver.getDrivingLicenseFirstFile());
        params.put("drivingLicenseSecondFile", driver.getDrivingLicenseSecondFile());
        params.put("drivingLicenseFirstEffect", driver.getDrivingLicenseFirstEffect());
        params.put("drivingLicenseEffectDate", driver.getDrivingLicenseEffectDate());
        params.put("drivingLicenseNo", driver.getDrivingLicenseNo());
        params.put("drivingLicenseType", driver.getDrivingLicenseType());
        params.put("NVQEffectDate", driver.getNVQEffectDate());
        params.put("NVQNo", driver.getNVQNo());
        params.put("state", driver.getState());
        params.put("serviceAgreement", driver.getServiceAgreement());
        params.put("entrustmentAgreement", driver.getEntrustmentAgreement());
        params.put("taxPaymentAgreement", driver.getTaxPaymentAgreement());
        params.put("sign",  createSignService.invokeFee(params));
//        headers.put("Content-Type", "application/x-www-form-urlencoded");
//        设置不校验签名
//        headers.put("twgdh", "xjdmg");
        JSONObject jsonObject = HttpUtils.doPost(interfaceUrl, params);
        System.out.println(jsonObject);
    }
}
