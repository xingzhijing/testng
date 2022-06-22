package com.xzj.base1.httpclient;

import com.feeclouds.pojo.HttpClientUtils;
import com.feeclouds.pojo.ResourceConfig;
import com.google.common.collect.Maps;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpClientWithPost {
    private String loginUrl;
    private String loginApi;
    private String username;
    private String pwd;
    private static Map<String, String> headers;
    private static String _xsrf;

    /**
     * 获取cookies，设置请求头
     * */
//    @DataProvider
    @BeforeTest
    public void beforeTest() throws IOException, URISyntaxException {
//        地址url
        this.loginUrl = ResourceConfig.getUrl("application", "test.login", null);
        Map<String, String> resultMap = HttpUtils.doGetToSid(loginUrl);
        _xsrf = resultMap.get("_xsrf");
        String sid = resultMap.get("sid");

//        登录接口
        this.loginApi = ResourceConfig.getUrl("application", "test.url", "login");
        Map<String, String> map = ResourceConfig.getUsernamePassword("account","test.username", "test.pwd");
        this.username = map.get("username");
        this.pwd = map.get("pwd");
        String authorization = HttpUtils.doPostToCookies(loginApi, username, pwd);
        System.out.println(authorization);

        String cookie = "";
//        设置headers
        headers = new HashMap<>();
        if (!_xsrf.isEmpty() && !sid.isEmpty() && !authorization.isEmpty()) {
            cookie = "_xsrf=" + _xsrf + "; " + "sid=" + sid + "; " + authorization;
            headers.put("cookie", cookie);
        }
        headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        headers.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36");

    }

    @Test()
    public void testApi() throws IOException {
        String homepage = ResourceConfig.getUrl("application", "test.url", "homepage");
        Map<String, String> params = new HashMap<>();
        params.put("_xsrf", URLEncoder.encode("2|48fccab6|3b7c460301d78358daeaca729d6a6e92|1654506148", "utf-8"));
        HttpUtils.doPost(homepage, headers, params);
    }

}
