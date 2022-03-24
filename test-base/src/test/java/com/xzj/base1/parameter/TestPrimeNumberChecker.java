package com.xzj.base1.parameter;

import com.xzj.base.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 使用注解 @DataProvider
 * **/
public class TestPrimeNumberChecker {
    private PrimeNumberChecker primeNumberChecker;

    @BeforeMethod
    private void initialize(){
        primeNumberChecker = new PrimeNumberChecker();
    }

    @DataProvider(name = "test1")
    public Object[][] dataProvider(){
        return new Object[][] {{2, true}, {6, false}, {7, true}, {9, false}};
    }

    @Test(dataProvider = "test1")
    public void testPrimeNumberChecker(Integer number, Boolean result){
        Boolean validateRes = primeNumberChecker.validate(number);
        Assert.assertEquals(validateRes, result);
    }
}
