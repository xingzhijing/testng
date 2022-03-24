package com.xzj.base1.depends;

import org.testng.annotations.Test;

public class TestDepends {
    @Test(groups = {"depend"})
    public void testFirst(){
        System.out.println("我是First!");
    }

    @Test(groups = {"depend"})
    public void testSecond(){
        System.out.println("我是second!");
//        System.out.println(1/0);
    }

    @Test(groups = {"fourthly"}, dependsOnGroups = {"third"})
    public void testThird(){
        System.out.println("我是fourthly!");
    }
}
