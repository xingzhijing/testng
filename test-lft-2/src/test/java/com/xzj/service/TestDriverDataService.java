package com.xzj.service;

import com.xzj.LFTApplication_2;
import com.xzj.dao.entity.ObjectCaseData;
import com.xzj.dao.service.object.ObjectCaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = LFTApplication_2.class)
public class TestDriverDataService extends AbstractTestNGSpringContextTests {
    @Autowired
    ObjectCaseDataService driverDataService;

    @Test
    public void testQueryDriverCaseData(){
        List<Long> longList = new ArrayList<Long>();
        longList.add(1L);
        List<ObjectCaseData> objectCaseDataList = driverDataService.listByIds(longList, "1");
        System.out.println(objectCaseDataList);
    }
}
