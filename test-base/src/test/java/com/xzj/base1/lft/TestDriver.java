package com.xzj.base1.lft;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feeclouds.pojo.ResourceConfig;
import com.xzj.base1.httpclient.HttpUtils;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDriver {
    private final Map<String, String> headers = new HashMap<>();
//    测试
//    1941
//    private static String company_key = "2fac02a6-b85d-4e3f-986d-d742e8354c04";
//    private final String testTax = "123456789098765";
//    1939
    private static String company_key = "44167fc5-c8e9-4ba0-9224-656345f26d5b";
    private final String testTax = "91330200MA282H486E";
//    生产
//    private final String company_key = "af6bce91-0eec-409b-9627-754d23dd087c";
//    private final String prodTax = "911101083065625168";
    private final String nonce_str = "z0SWco";
    private final Logger logger = Logger.getLogger(CreateSignUtils.class);

    @Test(enabled = true, priority = 0)
    public void CreateDriver() throws IOException {
        String createDriverApi = ResourceConfig.getUrl("application", "prod.lft", "create.driver");
        Map<String, String> params = new HashMap<>();
        params.put("company_key", company_key);
        params.put("nonce_str",  nonce_str);
//        测试
        params.put("taxno", testTax);
//        生产
//        params.put("taxno", prodTax);
        params.put("driverName", "菠菜");
        params.put("sex", "1");
        params.put("phoneNum", "15301322687");
        params.put("idCard", "142625199808202822");
        params.put("idCardEffectStart", DateUtils.localDateFormat(LocalDate.now().minusDays(1), "yyyy-MM-dd"));
        params.put("idCardEffectEnd", DateUtils.localDateFormat(LocalDate.now(), "yyyy-MM-dd"));
        params.put("idCardFaceFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("idCardGuohuiFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("bankAccount", "6212262502009182455");
        params.put("bankAccountName", "绿萝");
        params.put("bank", "招商银行北京西直门支行");
        params.put("drivingLicenseFirstFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("drivingLicenseSecondFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));

        params.put("drivingLicenseFirstEffect", DateUtils.localDateFormat(LocalDate.now().minusYears(1), "yyyy-MM-dd"));
        params.put("drivingLicenseEffectDate", "2022-08-21T2022-08-22");
        params.put("drivingLicenseNo", "411082199506054818");
        params.put("drivingLicenseType", "A1");
        params.put("NVQEffectDate", "2022-03-21T2022-03-22");
        params.put("NVQNo", "411082199506054818");
        params.put("state", "1");
        params.put("serviceAgreement", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("entrustmentAgreement", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("taxPaymentAgreement", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("sign",  CreateSignUtils.invokeFee(params));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
//        设置不校验签名
        headers.put("twgdh", "xjdmg");
        JSONObject jsonObject = HttpUtils.doPost(createDriverApi, headers, params);
//        System.out.println(params.get());
        System.out.println(jsonObject);
    }

    @Test(enabled = true, priority = 1)
    public void CreateCar() throws IOException {
        String createCarApi = ResourceConfig.getUrl("application", "prod.lft", "create.car");
        Map<String, String> params = new HashMap<>();
        params.put("company_key", company_key);
        params.put("nonce_str", nonce_str);
//        测试
        params.put("taxno", testTax);
//        生产
//        params.put("taxno", prodTax);
        params.put("plateNum", "京ALB1" + (int)(Math.random()*100));
        params.put("vehicleType", "一型货车");
        params.put("nuclearWeight", "10.02");
        params.put("totalWeight", "10.01");
        params.put("energyType", "燃油车");
        params.put("plateColor", "1");
        params.put("vehicleLicenseFirstFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("vehicleLicenseSecondFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
//        params.put("roadTransportPermitFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.jpg"));
        params.put("drivingEndDate", "2021-12-30");
        params.put("transportEndDate", "2044-07-11");
        params.put("transportNum", "聊371502313036");
        params.put("sign", CreateSignUtils.invokeFee(params));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
//        设置不校验签名
        headers.put("twgdh", "xjdmg");
        JSONObject jsonObject = HttpUtils.doPost(createCarApi, headers, params);
//        logger.info(params);

        System.out.println(params.get("plateNum"));

        System.out.println(jsonObject);
    }

    @Test(enabled = true, priority = 2)
    public void CreateOrder() throws IOException {
        String createOrderApi = ResourceConfig.getUrl("application", "test.lft", "create.order");
        Map<String, String> params = new HashMap<>();

        params.put("company_key", company_key);
        params.put("nonce_str", nonce_str);
//        测试
        params.put("taxno", testTax);
//        生产
//        params.put("taxno", prodTax);
        params.put("orderNum", "YD20220713" + (int)(Math.random()*10000));
        params.put("idCard", "142625199808202862");
        params.put("plateNum", "京ALB150");
//        params.put("plateColor", "1");
        params.put("sendAddress", "北京市海淀区");
        params.put("sendTime", DateUtils.localDateTimeFormat(LocalDateTime.now().minusDays(1), "yyyy-MM-dd HH:mm:ss"));
        params.put("receiveAddress", "北京市昌平区");
        params.put("receiveTime", DateUtils.localDateTimeFormat(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        params.put("amount", "1000");
        params.put("consignor", "百合");
        params.put("chargeType", "0");
//        运输合同附件
        params.put("protocolFileFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.pdf"));
        params.put("sendUserName", "绿萝");
        params.put("sendUserPhone", "15300002678");
        params.put("pickUpTime", DateUtils.localDateTimeFormat(LocalDateTime.now().minusDays(1), "yyyy-MM-dd HH:mm:ss"));
        params.put("receiveUserName", "百合");
        params.put("receiveUserPhone", "15300002678");
        params.put("signTime", DateUtils.localDateTimeFormat(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        params.put("contractAmount", "1000");
        params.put("lossAmount", "1");
        params.put("goods", JSON.toJSON(TestDriver.goodsInfo()).toString());
        params.put("tracks", JSON.toJSON(TestDriver.trackInfo()).toString());
        params.put("payItems", JSON.toJSON(TestDriver.payInfo()).toString());
        params.put("sign", CreateSignUtils.invokeFee(params));
        headers.put("Content-Type", "application/x-www-form-urlencoded");
//        设置不校验签名
//        headers.put("twgdh", "xjdmg");
        JSONObject jsonObject = HttpUtils.doPost(createOrderApi, headers, params);
        System.out.println(params.get("orderNum"));
        System.out.println(jsonObject);
    }

    /**
     *  货物信息
     * */
    public static List goodsInfo(){
        List<Map> goodsList = new ArrayList<>();
        Map<String, String> goodsMap = new HashMap();
        for (int i = 0; i < 2; i++) {
            goodsMap.put("goodsNum", "1000" + i);
            goodsMap.put("chargeType", "0");
            goodsMap.put("goodsName", "煤炭");
            goodsMap.put("goodsWeight", "10-吨");
//            goodsMap.put("goodsVolume", "10-升");
//            goodsMap.put("goodsCount", "100-");
            goodsList.add(goodsMap);
        }
        return goodsList;
    }

    /**
     *  轨迹信息
     * */
    public static List trackInfo(){
        List<Map> trackList = new ArrayList<>();
        Map<String, String> trackMap = new HashMap();
        for (int i = 0; i < 2; i++) {
            trackMap.put("lat", "11" + i);
            trackMap.put("lon", "1123");
            trackMap.put("gtm", "123");
            trackMap.put("spd", "223");
            trackMap.put("mlg", "3123");
            trackMap.put("hgt", "1000");
            trackMap.put("agl", "90");
            trackList.add(trackMap);
        }
        return trackList;
    }

    /**
     * 流水信息
     * */
    public static List payInfo(){
        List<Map> payList = new ArrayList<>();
        Map<String, String> payMap = new HashMap();
        for (int i = 0; i < 2; i++) {
            payMap.put("receiveAccount", "6212262502009182345" + i);
            payMap.put("receiveName", "张三");
            payMap.put("transferAmount", "1000");
            payMap.put("payAccount", "11050163030000000549");
            payMap.put("payName", "智运通（北京）科技有限责任公司");
            payMap.put("bankReceiptFile", Base64Utils.GetImageStr("/Users/xzj/Desktop/2.pdf"));
//            转账凭证流水号 必填
            payMap.put("serialNo", "9876543210");
//            其他银行流水信息 非必填
            payMap.put("extraInfo", "https://www.feeclouds.com");
            payList.add(payMap);
        }
        return payList;
    }


    @Test(enabled = false)
    public void test(){
        String encode = Base64Utils.GetImageStr("/Users/xzj/Desktop/1.jpeg");
//        System.out.println(encode);
        Base64Utils.GenerateImage(encode, "/Users/xzj/Desktop/test.jpeg");
    }

}
