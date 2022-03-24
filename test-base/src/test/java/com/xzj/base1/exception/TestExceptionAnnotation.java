package com.xzj.base1.exception;

import com.xzj.base.ExceptionAnnotation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestExceptionAnnotation {
    ExceptionAnnotation exceptionAnnotation = new ExceptionAnnotation();

    @Test(expectedExceptions = {ArithmeticException.class}, groups = "exception")
    public void testException(){
        Assert.assertEquals(exceptionAnnotation.division(), 0);
    }
}
