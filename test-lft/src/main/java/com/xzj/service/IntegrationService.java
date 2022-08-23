package com.xzj.service;

import com.xzj.config.DriverProperties;
import com.xzj.config.InterfaceName;
import com.xzj.config.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IntegrationService {

    @Autowired
    TestProperties testProperties;

    @Autowired
    DriverProperties driverProperties;


    public String integrationUrl(InterfaceName interfaceName){
        String interfaceUrl = testProperties.getHost();
        
//        开始拼接完整的URL
        if (StringUtils.hasText(String.valueOf(interfaceName))){
            if (interfaceName == InterfaceName.DRIVER_CREATE){
                interfaceUrl += driverProperties.getCreate();
            }else if (interfaceName == InterfaceName.DRIVER_DELETE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.DRIVER_UPDATE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.DRIVER_SELECT){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.CAR_CREATE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.CAR_DELETE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.CAR_UPDATE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.CAR_SELECT){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.ORDER_CREATE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.ORDER_DELETE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.ORDER_UPDATE){
                interfaceUrl += driverProperties.getDelete();
            }else if (interfaceName == InterfaceName.ORDER_SELECT){
                interfaceUrl += driverProperties.getDelete();
            }
        }
        return interfaceUrl;
    }
}
