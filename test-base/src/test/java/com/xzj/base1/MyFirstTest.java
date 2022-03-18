package com.xzj.base1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    void testAddMethod(){
        int a = 10;
        int b = 20;
        int actualResult = a + b;
        Assert.assertEquals(actualResult, 30);
    }

    @Test
    void testMultiplyMethod(){
        int c = 10;
        int d = 2;
        int actualResult = c/d;
        Assert.assertEquals(actualResult, 5);
    }
}
