package com.xzj.base1.lft;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.cli.Digest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.ResponseContent;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.util.DigestUtils;
import org.testng.collections.Lists;
import org.testng.log4testng.Logger;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CreateSignUtils {
//    测试
//    private static String company_key = "2fac02a6-b85d-4e3f-986d-d742e8354c04";
//    private static String c_secret = "bf7cabfb-d3bc-4d2e-b555-44c4fd864db0";
//    生产
    private static String company_key = "af6bce91-0eec-409b-9627-754d23dd087c";
    private static String c_secret = "b04be205-3953-4e9c-b037-1fae320c33ca";

    public static String invokeFee(@NotNull Map<String, String> kvMap) {
        Logger logger = Logger.getLogger(CreateSignUtils.class);
//        kvMap.put("company_key", company_key);
        //6位随机字符串
//        kvMap.put("nonce_str", AppUitls.randomStr(6));
//        kvMap.put("nonce_str", "z0SWco");
        Map<String, Object> resultMap = new HashMap<>();
        ArrayList<String> keys = (ArrayList<String>) Lists.newArrayList(kvMap.keySet());
        Collections.sort(keys);
        try {
            StringBuilder params = new StringBuilder();
            for (String key : keys) {
                params.append(key);
                params.append("=");
                params.append(kvMap.get(key));
                params.append("&");
                resultMap.put(key, kvMap.get(key).toString());
            }
            params.append(URLEncoder.encode("company_secret", "utf-8"));
            params.append("=");
            params.append(URLEncoder.encode(c_secret, "utf-8"));
//            System.out.println("参数排序后为: " + params.toString());
//            logger.info("参数排序后为: " + params.toString());
//            String md5 = Md5.getEncode(params.toString());
            String md5 = DigestUtils.md5DigestAsHex(params.toString().getBytes(StandardCharsets.UTF_8)).toUpperCase();
            resultMap.put("sign", md5);
            logger.info("======>>加密后签名: " + md5);
            return md5;
        } catch (Exception e) {
            logger.error("======>>签名失败:", e);
            return null;
        }

//        if (ignore != null)
//            resultMap.putAll(ignore);
//        Object content = null;
//        try {
//            if(method==HTTP_GET){
//                CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute();
//                String reponse = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
//                JSONObject jsonObject = JSON.parseObject(reponse);
//                System.out.println(jsonObject);
//                String entity = HttpHelper.doGetEntity(url, resultMap);
//                content = new JacksonJsonParser().parseMap(entity);
//            }else{
//                ResponseContent postEntity = HttpHelper.postEntity(url, resultMap);
//                content = new JacksonJsonParser().parseMap(postEntity.getContent());
//            }
//            logger.info("feecloud reponse: " +content);
//        } catch (Exception e) {
//            logger.error("invoke feecloud failed: ", e);
//            return ErrorResps.INVOKE_FEECLOUD_FAILED.get();
//        }
//
//        logger.info("======费耘返回数据: " + content);

//        return content;
    }
}
