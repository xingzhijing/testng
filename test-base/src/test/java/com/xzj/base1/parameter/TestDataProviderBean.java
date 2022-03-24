package com.xzj.base1.parameter;

import com.xzj.base.Student;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProviderBean {
    @DataProvider(name = "student")
    public Object[][] providerBean(){
        return new Object[][] {{new Student("xzj", 20)}};
    }

    @Test(dataProvider = "student")
    public void testStudentBean(Student student){
        System.out.println(student.getName() + "," + student.getAge());
    }
}
