package com.xzj.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle resourceBundle;

    /**
     * 获取接口的URL
     *
     * @param interfaceName 请求接口名
     * */
    public String getUrl(String interfaceName){
        return getUrl("application", interfaceName);
    }

    /**
     * 获取请求的URL
     *
     * @param propertiesName 读取的配置文件名
     * @param interfaceName 请求接口名
     * */
    public static String getUrl(String propertiesName, String interfaceName){
        resourceBundle = ResourceBundle.getBundle(propertiesName, Locale.CHINA);
        String host = resourceBundle.getString("test.url");
//        String interfaceUri = resourceBundle.getString(urlKey);
        String urlValue = "";
//        if (apiKey != null && !apiKey.equals("")){
//            urlValue = interfaceUri + resourceBundle.getString(apiKey);
//        }
        return urlValue;
    }

}
