package com.xzj.utils;

import com.xzj.dto.InterfaceName;
import com.xzj.utils.properties.TestEnvProperties;
import com.xzj.utils.properties.UserProperties;
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
     *
     * @param: 接口key的enum
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
        }else if (interfaceName == ETC_CARD){
            interfaceUrl = testEnvUrl + userProperties.getEtcCard();
        }else if (interfaceName == ETC_CARD_EXPORT){
            interfaceUrl = testEnvUrl + userProperties.getEtcCardExport();
        }
        else {
            return testEnvUrl;
        }
        return interfaceUrl;
    }
}
