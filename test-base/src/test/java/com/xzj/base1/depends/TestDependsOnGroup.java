package com.xzj.base1.depends;

import org.testng.annotations.Test;

public class TestDependsOnGroup {

    @Test(groups = {"third"}, dependsOnGroups = {"depend"})
    public void testGroupFirst(){
        System.out.println("我是Group-First");
    }
    @Test(groups = {"third"}, dependsOnMethods = {"testMethodFirst"})
    public void testGroupSecond(){
        System.out.println("我是Group-Second");
    }
}
