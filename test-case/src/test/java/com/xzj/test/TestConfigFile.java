package com.xzj.test;

import com.xzj.utils.ConfigFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class TestConfigFile {
    @Autowired
    ConfigFile configFile;
    @Test
    public void testUrl(){
        System.out.println(configFile.getUrl());
    }
}
//shishi
