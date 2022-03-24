package com.xzj.base1.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
* 使用注解 @Parameters
* */

public class TestParameter {
    @Test
    @Parameters({"myName"})
    public void testMyName(String myName){
        System.out.println("My name is " + myName);
    }
}
