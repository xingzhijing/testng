package com.xzj.base1.priority;

import com.xzj.base.MessageUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMessageUtil {
    String message = "Manisha";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(enabled = true)
    public void testPrintMessage(){
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test
    public void testSalutationMessage(){
        message = "Hi!" + "Manisha";
        Assert.assertEquals(message, messageUtil.SalutationMessage());
    }
}
