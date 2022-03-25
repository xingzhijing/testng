//package com.feeclouds.login;
//
//public class HttpClientHelper {
//    public static String sendPost(String urlParam) throws HttpException, IOException {
//        // 创建httpClient实例对象
//        HttpClient httpClient = new HttpClient();
//        // 设置httpClient连接主机服务器超时时间：15000毫秒
//        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
//        // 创建post请求方法实例对象
//        PostMethod postMethod = new PostMethod(urlParam);
//        // 设置post请求超时时间
//        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
//        postMethod.addRequestHeader("Content-Type", "application/json");
//
//        httpClient.executeMethod(postMethod);
//
//        String result = postMethod.getResponseBodyAsString();
//        postMethod.releaseConnection();
//        return result;
//    }
//    public static String sendGet(String urlParam) throws HttpException, IOException {
//        // 创建httpClient实例对象
//        HttpClient httpClient = new HttpClient();
//        // 设置httpClient连接主机服务器超时时间：15000毫秒
//        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
//        // 创建GET请求方法实例对象
//        GetMethod getMethod = new GetMethod(urlParam);
//        // 设置post请求超时时间
//        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
//        getMethod.addRequestHeader("Content-Type", "application/json");
//
//        httpClient.executeMethod(getMethod);
//
//        String result = getMethod.getResponseBodyAsString();
//        getMethod.releaseConnection();
//        return result;
//    }
//    public static void main(String[] args) throws HttpException, IOException {
//        String url ="http://int.dpool.sina.com.cn/iplookup/iplookup.php?ip=120.79.75.96";
//        System.out.println(sendPost(url));
//        System.out.println(sendGet(url));
//    }
//}
