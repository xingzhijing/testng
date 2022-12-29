package com.xzj.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpUtils {

    public void doGet(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpGet.setConfig(defaultConfig);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
    }

    /**
     * 发送post请求；带请求参数
     *
     * @param url 请求地址
     * @param params 请求参数
     * @return
     * @throws Exception
     */
    public static JSONObject doPost(String url, Map<String, Object> params) throws Exception {
        return doPost(url, null, params);
    }

    /**
     * 发送post请求；带请求参数
     *
     * @param url 请求地址
     * @param headerMap  请求头
     * @param params 参数集合
     * @return
     * @throws Exception
     */
    public static JSONObject doPost(String url, Map<String, String> headerMap, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpPost.setConfig(defaultConfig);
//        设置请求头
        packageHeader(headerMap, httpPost);
//        设置参数
        packageParam(params, httpPost);
//        发送请求
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute(httpPost);
        String reponse = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        JSONObject jsonObject = JSON.parseObject(reponse);
        return jsonObject;
    }

    /**
     * Description: 封装请求头
     * @param params
     * @param httpMethod
     */
    public static void packageHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // 封装请求头
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // 设置到请求头到HttpRequestBase对象中
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Description: 封装请求参数
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException
     */
    public static void packageParam(Map<String, Object> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // 封装请求参数
        if (params != null) {
            List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
            Set<Map.Entry<String, Object>> entrySet = params.entrySet();
            for (Map.Entry<String, Object> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
            }
            // 设置到请求的http对象中
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        }
    }


    public static Map<String, String> doGetToSid(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建http对象
        HttpGet httpGet = new HttpGet(url);

//        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
//        httpGet.setConfig(requestConfig);
        RequestConfig cookieSpecConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpGet.setConfig(cookieSpecConfig);

        // 创建httpResponse对象
        CloseableHttpResponse httpResponse = null;

//        创建cookieStore对象
        BasicCookieStore cookieStore = new BasicCookieStore();
//        创建HttpclientContext对象
        HttpClientContext clientContext = HttpClientContext.create();
//        设置cookieStore
        clientContext.setCookieStore(cookieStore);
//        创建HttpClientCookiesResult对象
        Map<String, String> resultMap = new HashMap<String, String>();

        try {
            // 执行请求并获得响应结果
            httpResponse = httpClient.execute(httpGet, clientContext);
            List<Cookie> cookieList = clientContext.getCookieStore().getCookies();
            String cookieXsrf = cookieList.stream()
                    .filter(cookie -> "_xsrf".equals(cookie.getName()))
                    .findFirst()
                    .get()
                    .getValue();
            String cookieSid = cookieList.stream()
                    .filter(cookie -> "sid".equals(cookie.getName()))
                    .findFirst()
                    .get()
                    .getValue();
            //想返回多个参数

            resultMap.put("_xsrf", cookieXsrf);
            resultMap.put("sid", cookieSid);
            return resultMap;

        }catch (Exception e){
            System.out.println(e);
            return null;
        }
//        finally {
//            // 释放资源
//            release(httpResponse, httpClient);
//        }

    }


    public static String doPostToCookies(String url, String username, String pwd) throws IOException {
//        创建httpclient，创建请求方式，发送请求
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
//        登录时所需的参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("username", username));
        nameValuePairs.add(new BasicNameValuePair("password", pwd));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
//        修改请求中的cookie策略，解决警告：Invalid cookie header
        RequestConfig defaultConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        httpPost.setConfig(defaultConfig);
//        发请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//        响应结果
        String result = EntityUtils.toString(httpResponse.getEntity(), "utf-8");
        System.out.println(result);

//        获取cookies信息
        Header[] headers = httpResponse.getHeaders("Set-Cookie");
        String authorization = Arrays.stream(headers)
                .filter(header -> "Set-Cookie".equals(headers[0].getName()))
                .findFirst()
                .get()
                .getValue()
                .split(";")[0];
//        System.out.println(Authorization);
        return authorization;
    }

    /**
     * Description: 释放资源
     *
     * @param httpResponse
     * @param httpClient
     * @throws IOException
     */
    public static void release(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient) throws IOException {
        // 释放资源
        if (httpResponse != null) {
            httpResponse.close();
        }
        if (httpClient != null) {
            httpClient.close();
        }
    }

}
