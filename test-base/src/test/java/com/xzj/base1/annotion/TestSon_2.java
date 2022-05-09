package com.xzj.base1.annotion;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestSon_2 extends TestFather{
    // test case 1
    @Test
    public void testCase1() {
//        System.out.println("testSon_2 in test case 1");
        Assert.assertEquals(1, 2);
    }
    // test case 2
    @Test
    public void testCase2() {
        System.out.println("testSon_2 in test case 2");
    }
}
