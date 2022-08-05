package com.xzj.test;

import com.xzj.ServletInitializer;
import com.xzj.utils.ConfigFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ServletInitializer.class)
public class TestConfigFile {

    @Autowired
    ConfigFile configFile;

    @Test
    public void testUrl(){
        System.out.println(configFile.getUrl());
    }
}
//shishi
