package com.xzj.utils;

//import com.xzj.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.testng.collections.Lists;
import org.testng.log4testng.Logger;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreateSignUtils {

    /**
     * 生成签名
     * */
    public static String invokeFee(@NonNull Map<String, Object> kvMap,
                            @NonNull String companySecret) {
        Logger logger = Logger.getLogger(CreateSignUtils.class);
        //6位随机字符串
        kvMap.put("nonce_str", RandomStrUtils.getRandomStr(6));
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
            params.append(URLEncoder.encode("company_secret", StandardCharsets.UTF_8));
            params.append("=");
            params.append(URLEncoder.encode(companySecret, StandardCharsets.UTF_8));
//            System.out.println("参数排序后为: " + params.toString());
            String md5 = DigestUtils.md5DigestAsHex(params.toString().getBytes(StandardCharsets.UTF_8)).toUpperCase();
            resultMap.put("sign", md5);
            logger.info("======>>加密后签名: " + md5);
            return md5;
        } catch (Exception e) {
            logger.error("======>>签名失败:", e);
            return null;
        }
    }

}
