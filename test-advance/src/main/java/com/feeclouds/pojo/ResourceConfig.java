package com.feeclouds.pojo;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ResourceConfig {
    private static String urlValue;
    private static String username;
    private static String pwd;

    /**
     * 返回url
     * */
    public static String getUrl(String propertiesName, String urlKey, String apiKey){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesName);
        urlValue = resourceBundle.getString(urlKey);
        if (apiKey != null && !apiKey.equals("")){
             urlValue = urlValue+ resourceBundle.getString(apiKey);
        }
        return urlValue;
    }

    /**
     * 返回登录账号 密码
     * */
    public static Map<String, String> getUsernamePassword(String propertiesName, String name, String password){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(propertiesName);
        username = resourceBundle.getString(name);
        pwd = resourceBundle.getString(password);
        Map<String, String> mapAccount = new HashMap<>();
        mapAccount.put("username", username);
        mapAccount.put("pwd", pwd);
        return mapAccount;
    }
}
