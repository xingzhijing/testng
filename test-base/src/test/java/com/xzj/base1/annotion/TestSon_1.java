package com.xzj.base1.annotion;

import org.testng.annotations.*;

public class TestSon_1 extends TestFather{
    // test case 1
    @Test
    public void testCase1() {
        System.out.println("testSon_1 in test case 1");
    }
    // test case 2
    @Test
    public void testCase2() {
        System.out.println("testSon_1 in test case 2");
    }

}
