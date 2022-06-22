package com.xzj.base1.httpclient;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ResourceBundle;

public class HttpClientWithGet {
    private String url;

    /**
     * 获取请求的url
     * */
    @BeforeTest
    public void beforeTest() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        this.url = resourceBundle.getString("test.url") + resourceBundle.getString("api.cookies");
    }

    @Test
    public void testGetCookies() throws IOException {
//        创建httpclient，创建请求方式，发送请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(this.url);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);

//        获取cookies信息
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        for (Header header: headers) {
            System.out.println(header);
            
        }
    }
}
