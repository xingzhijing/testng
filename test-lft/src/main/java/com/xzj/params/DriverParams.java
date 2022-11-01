package com.xzj.params;

import com.xzj.config.TestProperties;
import com.xzj.dto.Driver;
import com.xzj.utils.Base64Utils;
import com.xzj.utils.DateUtils;
import org.springframework.stereotype.Component;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class DriverParams{

    @DataProvider(name = "createDriverProvider")
    public static Iterator<Object[]> driverData(){

        List<Driver> driverList = new ArrayList<>();
        List<Object[]> listArr = new ArrayList<>();
//        String taxNo = testProperties.getTax();

        driverList.add(new Driver(
                "令狐冲",
                "1",
                "15803020813",
                "142625199809202862",
                DateUtils.localDateFormat(LocalDate.now().minusDays(1), "yyyy-MM-dd"),
                DateUtils.localDateFormat(LocalDate.now(), "yyyy-MM-dd"),
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
                "IdCardFaceFile",
                "IdCardGuoHuiFile",
                "6212262502009182455",
                "我是收款账户",
                "招商银行北京西直门支行",
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
                "DrivingLicenseFirstFile",
                "DrivingLicenseSecondFile",
                DateUtils.localDateFormat(LocalDate.now().minusYears(1), "yyyy-MM-dd"),
                "2020-08-21T2023-08-22",
                "411082199506054818",
                "A1",
                "2022-03-21T2022-03-22",
                "411082199506054818",
                "1",
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"),
//                Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg")
                "serviceAgreement",
                "entrustmentAgreement",
                "taxPaymentAgreement"
                ));
        for (Object driver: driverList) {
            listArr.add(new Object[]{driver});
        }
        return listArr.iterator();
    }

}
