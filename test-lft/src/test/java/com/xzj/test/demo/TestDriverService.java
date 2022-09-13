package com.xzj.test.demo;

import com.xzj.LFTApplication;
import com.xzj.dto.TestDataDTO;
import com.xzj.entity.TestData;
import com.xzj.service.TestDriverDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = LFTApplication.class)
public class TestDriverService extends AbstractTestNGSpringContextTests {
    private String sql;

    @Autowired
    private TestDriverDataService testDriverDataService;

    @Parameters({"sql"})
    @BeforeClass
    public void beforeClass(String sql){
        this.sql = sql;
    }

    @DataProvider(name = "testData")
    public Object[][] getDriverData(){
        List<TestData> mapList = testDriverDataService.getTestDriverDataOneById(sql);
        Object[][] objects = new Object[mapList.size()][];
        for (int i = 0; i < mapList.size(); i++) {
            objects[i] = new Object[]{mapList.get(i)};
        }
        return objects;
    }

    @Test(dataProvider = "testData")
    public void testDriverDataService(TestData testData){
        System.out.println(testData);
    }

}
