//package com.feeclouds.login;
//
//import com.feeclouds.pojo.UserLoginInfo;
//import org.apache.commons.httpclient.Cookie;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.cookie.CookiePolicy;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//public class HttpLogin {
//
//    @DataProvider(name = "login")
//    public Object[][] testLoginInfo(){
////        测试环境
////        UserLoginInfo userLoginInfo = new UserLoginInfo("http://8.141.174.255:8084/login", "12345wlmq@qq.com", "1234Qwer");
////        生产环境
//        UserLoginInfo userLoginInfo = new UserLoginInfo("https://www.feeclouds.com/login", "xingzhijing124@deallinker.com", "1234Qwer");
//        return new Object[][]{{userLoginInfo}};
//    }
//
//    @Test(dataProvider = "login")
//    public static String doPost(Map<String, String> map, String charset) {
//        CloseableHttpClient httpClient = null;
//        HttpPost httpPost = null;
//        String result = null;
//        try {
//            CookieStore cookieStore = new BasicCookieStore();
//            httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
//            httpPost = new HttpPost("https://www.feeclouds.com/login");
//            List<NameValuePair> list = new ArrayList<NameValuePair>();
//            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//            while (iterator.hasNext()) {
//                Entry<String, String> elem = (Entry<String, String>) iterator.next();
//                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
//            }
//            if (list.size() > 0) {
//                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
//                httpPost.setEntity(entity);
//            }
//            httpClient.execute(httpPost);
//            String JSESSIONID = null;
//            String cookie_user = null;
//            List<Cookie> cookies = cookieStore.getCookies();
//            for (int i = 0; i < cookies.size(); i++) {
//                if (cookies.get(i).getName().equals("JSESSIONID")) {
//                    JSESSIONID = cookies.get(i).getValue();
//                }
//                if (cookies.get(i).getName().equals("cookie_user")) {
//                    cookie_user = cookies.get(i).getValue();
//                }
//            }
//            if (cookie_user != null) {
//                result = JSESSIONID;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//
//}
