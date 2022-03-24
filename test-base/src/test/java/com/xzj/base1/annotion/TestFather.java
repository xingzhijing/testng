package com.xzj.base1.annotion;

import org.testng.annotations.*;

public class TestFather {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("我是Father in beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("我是Father in afterMethod");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("我是Father in beforeClass");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("我是Father in afterClass");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("我是Father in beforeTest");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("我是Father in afterTest");
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("我是Father in beforeSuite");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("我是Father in afterSuite");
    }
}
