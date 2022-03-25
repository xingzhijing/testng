package com.feeclouds.login;

import com.feeclouds.pojo.UserLoginInfo;
import com.google.common.base.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class TestLogin {
    @DataProvider(name = "login")
    public Object[][] testLoginInfo(){
        UserLoginInfo userLoginInfo = new UserLoginInfo("http://8.141.174.255:8084/login", "12345wlmq@qq.com", "1234Qwer");
//        UserLoginInfo userLoginInfo = new UserLoginInfo("https://www.feeclouds.com/login", "xingzhijing124@deallinker.com", "1234Qwer");
        return new Object[][]{{userLoginInfo}};
    }

    @Test(dataProvider = "login", enabled = false)
//    @DataProvider(name = "cookie")
    public String testLogin(UserLoginInfo userLoginInfo) throws InterruptedException {
       WebDriver webDriver = new ChromeDriver();
       String url = userLoginInfo.getUrl();
       String username = userLoginInfo.getUsername();
       String password = userLoginInfo.getPassword();
//       登录系统
       webDriver.get(url);
       webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
       webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
       webDriver.findElement(By.xpath("//*[@id=\"login-btn\"]")).click();
//       Thread.sleep(1);
//       获取Cookie
       Set<Cookie> cookieSet = webDriver.manage().getCookies();
       System.out.println(cookieSet);
       String cookies = null;
       for (Cookie cookie: cookieSet) {
           cookies += cookie.getName() + "=" + cookie.getValue() + ";";
       }
       System.out.println(cookies);
       Thread.sleep(3);

//       退出
       webDriver.close();
       webDriver.quit();
       return cookies;
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
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
        HttpEntity entity= response.getEntity();
        String content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        System.out.println("字符集：" + entity.getContentEncoding());
        System.out.println(new String(content.getBytes(StandardCharsets.UTF_8)));

//        System.out.println(content);
        return content;




       /* // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.addRequestHeader("Cookie", "_xsrf=2|a31ae610|960d738d4573435a7add51e3e1e79832|1648022590; Authorization=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb21wYW55X2lkIjoxOTQxLCJ1c2VyX2lkIjo1Mjg4NCwiZGVwYXJ0bWVudF9pZCI6MTU3ODIsImFuZCI6MSwiZXhwIjoxNjQ5MzE3MDU2fQ.isdHwi0FTrHTEoFjGelpr_g14jeJr6h3KPalqFikQWA");
        postMethod.addRequestHeader("Content-Type", "application/json");

        httpClient.executeMethod(postMethod);
        String result = postMethod.getResponseBodyAsString();
        result.getBytes("utf-8");
//        EntityUtils.toString(result.getEntity(), "UTF-8");
        postMethod.releaseConnection();
        return result;*/
    }

    @Test
    public void testCardList() throws IOException{
        System.out.println(sendPost("http://8.141.174.255:8084/etc/card/kind/list"));

    }
}
