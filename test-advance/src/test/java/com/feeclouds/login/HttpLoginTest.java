package com.feeclouds.login;

import com.alibaba.fastjson.JSON;
import com.feeclouds.pojo.HttpClientResult;
import com.feeclouds.pojo.HttpClientUtils;
import com.feeclouds.pojo.UserLoginInfo;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpLoginTest{
    @DataProvider(name = "loginInfo")
    public static Object[][] loginInfo(){
        UserLoginInfo userLoginInfo = new UserLoginInfo(
                "http://8.141.174.255:8084/",
                "12345wlmq@qq.com",
                "Y7wERgSRWejG2btnRjtCEg==");
        return new Object[][]{{userLoginInfo}};
    }

    /**
     * 登录接口
     **/
    @Test(dataProvider = "loginInfo")
    public void httpLogin(UserLoginInfo userLoginInfo) throws Exception {
        String api = "ajax/user/login";
        Map<String, String> paramsMap = new HashMap<>();
        paramsMap.put("username", userLoginInfo.getUsername());
        paramsMap.put("password", userLoginInfo.getPassword());
//        发送请求
        HttpClientResult result = HttpClientUtils.doPost(userLoginInfo.getUrl() + api, paramsMap);
        System.out.println(result);


    }


    public static void main(String[] args) throws IOException {
//        登录的url
        String httpLoginUrl = "http://8.141.174.255:8084/ajax/user/login";
//        String httpLoginUrl = "https://www.feeclouds.com/ajax/user/login";
//        创建用户信息对象 不清楚密码的加密策略，直接用加密好的数据传参
        UserLoginInfo userLoginInfo = new UserLoginInfo(httpLoginUrl, "12345wlmq@qq.com", "Y7wERgSRWejG2btnRjtCEg==");
//        UserLoginInfo userLoginInfo = new UserLoginInfo(httpLoginUrl, "xingzhijing124@deallinker.com", "Y7wERgSRWejG2btnRjtCEg==");
//        创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpClient httpClient = new DefaultHttpClient();
//        模拟登录 选用post方式
        HttpPost httpPost = new HttpPost(httpLoginUrl);
//        登录时所需的参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username", userLoginInfo.getUsername()));
        nameValuePairs.add(new BasicNameValuePair("password", userLoginInfo.getPassword()));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
//        修改请求中的cookie策略，解决警告：Invalid cookie header
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpPost.setConfig(defaultConfig);

        String cookie = "";
//        发送请求
        HttpResponse httpResponse = httpClient.execute(httpPost);
//        接收返回信息
        HttpEntity httpEntity = httpResponse.getEntity();
        String content = EntityUtils.toString(httpEntity, "UTF-8");
        String response = JSON.parse(content).toString();
        System.out.println(response);
        System.out.println(httpResponse);
//        获取response中的cookie
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        String headersStr = headers.toString();
        for (int i = 0; i < headers.length; i++) {
            cookie += headers[i].getValue() + ";";
            System.out.println(cookie);
        }
        System.out.println("遍历完的cookie：" + cookie);


//        /*// 需要获取数据的URL
//        // 首页接口url
//        HttpPost httpost2 = new HttpPost("http://8.141.174.255:8084/ajax/homepage");
//        // 设置之前获取到的cookie
//        httpost2.setHeader("Cookie", cookie);
//        httpost2.setHeader("Content-Type", "application/json;charset=UTF-8");
//        httpost2.setHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.75 Safari/537.36");
//        HttpResponse response2 = httpClient.execute(httpost2);
//        String str2 = EntityUtils.toString(response2.getEntity());
//        System.out.println(JSON.parse(str2).toString());*/
    }
}