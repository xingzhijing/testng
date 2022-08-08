package com.xzj.test;

import com.xzj.ServletInitializer;
import com.xzj.utils.TestEnvProperties;
import com.xzj.utils.UserProperties;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ServletInitializer.class)
public class TestAllProperties extends AbstractTestNGSpringContextTests{

    @Autowired
    TestEnvProperties testEnvProperties;

    @Autowired
    UserProperties userProperties;

    @Test
    public void testEnvUrl(){
        System.out.println(testEnvProperties.getUrl());
        System.out.println(testEnvProperties.getLogin());
    }

    @Test
    public void testUserInterfaceUrl(){
        String addUrl = userProperties.getAdd();
        String infoUrl = userProperties.getDelete();
        String updateUrl = userProperties.getUpdate();
        String deleteUserUrl = userProperties.getFind();

        System.out.println("addUrl: " + addUrl);
        System.out.println("infoUrl: " + infoUrl);
        System.out.println("updateUrl: " + updateUrl);
        System.out.println("deleteUserUrl: " + deleteUserUrl);

    }
}
