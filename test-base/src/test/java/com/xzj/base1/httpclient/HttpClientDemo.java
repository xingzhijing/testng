package com.xzj.base1.httpclient;

import lombok.ToString;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
@ToString
public class HttpClientDemo {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//        getEntity()获取响应的所有内容
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(result);
    }


}
