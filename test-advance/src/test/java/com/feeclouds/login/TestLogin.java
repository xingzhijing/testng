package com.feeclouds.login;

import com.alibaba.fastjson.JSON;
import com.feeclouds.pojo.UserLoginInfo;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class TestLogin {
    @DataProvider(name = "login")
    public Object[][] testLoginInfo(){
        UserLoginInfo userLoginInfo = new UserLoginInfo("http://8.141.174.255:8084/login", "12345wlmq@qq.com", "1234Qwer");
//        UserLoginInfo userLoginInfo = new UserLoginInfo("https://www.feeclouds.com/login", "xingzhijing124@deallinker.com", "1234Qwer");
        return new Object[][]{{userLoginInfo}};
    }

    @Test(dataProvider = "login")
    public void testLogin(UserLoginInfo userLoginInfo) throws InterruptedException {
       WebDriver webDriver = new ChromeDriver();
       ChromeOptions chromeOptions = new ChromeOptions();
       String url = userLoginInfo.getUrl();
       String username = userLoginInfo.getUsername();
       String password = userLoginInfo.getPassword();
//       登录系统
       webDriver.get(url);
       webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
       webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
       webDriver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
       chromeOptions.setHeadless(false);
       chromeOptions.setScriptTimeout(Duration.ofDays(10));
//       Thread.sleep(1);
//       获取Cookie
       Set<Cookie> cookieSet = webDriver.manage().getCookies();
//       System.out.println(cookieSet);
       String cookies = "";
       for (Cookie cookie: cookieSet) {
           cookies += cookie.getName() + "=" + cookie.getValue() + ";";
       }
       System.out.println(cookies);
       Thread.sleep(3);

//       退出
       webDriver.close();
       webDriver.quit();
//       return cookies;
    }

    public static String sendPost(String urlParam) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(urlParam);
        httpPost.addHeader("Cookie", "_xsrf=2|a31ae610|960d738d4573435a7add51e3e1e79832|1648022590; Authorization=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb21wYW55X2lkIjoxOTQxLCJ1c2VyX2lkIjo1Mjg4NCwiZGVwYXJ0bWVudF9pZCI6MTU3ODIsImFuZCI6MSwiZXhwIjoxNjQ5MzE3MDU2fQ.isdHwi0FTrHTEoFjGelpr_g14jeJr6h3KPalqFikQWA");
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        CloseableHttpResponse response = null;
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        response = httpclient.execute(httpPost);
        HttpEntity entity= response.getEntity();
        String content = EntityUtils.toString(entity, "UTF-8");
        String res = JSON.parse(content).toString();
        return res;
    }

//    @Test
//    public void testCardList() throws IOException{
//        System.out.println(sendPost("http://8.141.174.255:8084/etc/card/kind/list"));
//    }
}
