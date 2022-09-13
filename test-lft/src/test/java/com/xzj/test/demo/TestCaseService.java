package com.xzj.test.demo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzj.LFTApplication;
import com.xzj.entity.CaseData;
import com.xzj.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.DisabledIf;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@SpringBootTest(classes = LFTApplication.class)
public class TestCaseService extends AbstractTestNGSpringContextTests {
    private String sql;
    @Autowired
    CaseService caseService;

    @Test
    public void testCaseServiceById(){
        List<CaseData> caseDataList = caseService.getCaseListByCondition(1);
        System.out.println(caseDataList);
    }

    @Test
    public void testGetCaseListByParam() throws IOException {
        JSONArray jsonArray = caseService.getCaseListByParam("http://8.141.174.255:8084");
        System.out.println(jsonArray);
    }

}
