package com.xzj.base1.priority;

import com.xzj.base.MessageUtil2;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @priority 指定执行的优先级：default=0，值越大，优先级越低
 * **/

public class TestMessageUtil2 {
    String message = "xzj";
    MessageUtil2 messageUtil2 = new MessageUtil2(message);

    @Test(priority = 1, groups = {"checkInTest"})
    public void testPrintMessage(){
        message = "xzj";
        Assert.assertEquals(message, messageUtil2.printMessage());
    }

    @Test(priority = 2, groups = {"funcTest"})
    public void testSalutionMessage(){
        message = "wiki." + "xzj";
        Assert.assertEquals(message, messageUtil2.salutationMessage());
    }

    @Test(priority = 3, groups = {"checkInTest"})
    public void testExitMessage(){
        message = "www." + "wiki." + "xzj";
        Assert.assertEquals(message, messageUtil2.exitMessage());
    }
}
