package com.xzj.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "configfile")
public class ConfigFile {
    private String url;

    private String addUserUrl;

    private String getUserInfoUrl;

    private String updateUserInfoUrl;

    /**
     * 获取接口的URL
     *
     * @param interfaceName 请求接口名
     * */
//    public String getUrl(String interfaceName){
//        return getUrl("application", interfaceName);
//    }

    /**
     * 获取请求的URL
     *
     * @param propertiesName 读取的配置文件名
     * @param interfaceName 请求接口名
     * */
//    public static String getUrl(String propertiesName, String interfaceName){
////        resourceBundle = ResourceBundle.getBundle(propertiesName, Locale.CHINA);
////        String host = resourceBundle.getString("test.url");
//
//        return "";
//    }

//    public static void main(String[] args) {
//        System.out.println(ConfigFile.getHostUrl());
//        ConfigFile configFile = new ConfigFile();
//        System.out.println(configFile.getAddUserUrl());
//    }

}
