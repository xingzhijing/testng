package com.xzj.utils;

import com.xzj.dto.InterfaceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.xzj.dto.InterfaceName.*;

/**
 * 组装类
 * */
@Component
public class IntegrationUtils {
    @Autowired
   TestEnvProperties testEnvProperties;

    @Autowired
    UserProperties userProperties;

    /**
     * 组装接口url
     * */
    public String integrationUrl(InterfaceName interfaceName){
        String testEnvUrl = testEnvProperties.getUrl();
        String interfaceUrl = "";

        if (interfaceName == ADDUSER){
            interfaceUrl = testEnvUrl + userProperties.getAdd();
        }else if (interfaceName == DELETEUSER){
            interfaceUrl = testEnvUrl + userProperties.getDelete();
        }else if (interfaceName == UPDATEUSERINFO){
            interfaceUrl = testEnvUrl + userProperties.getUpdate();
        }else if (interfaceName == GETUSERINFO){
            interfaceUrl = testEnvUrl + userProperties.getFind();
        }else if (interfaceName == HOMEPAGE){
            interfaceUrl = testEnvUrl + userProperties.getHomepage();
        }else {
            return testEnvUrl;
        }
        return interfaceUrl;
    }
}
