package com.xzj.base1.depends;

import org.testng.annotations.Test;

public class TestDependsOnMethod {

    @Test(groups = {"method_first"})
    public void testMethodFirst(){
        System.out.println("我是method-First");
    }

    @Test(groups = {"method_first"}, dependsOnMethods = {"testMethodFirst"})
    public void testMethodSecond(){
        System.out.println("我是method-Second");
    }
}
