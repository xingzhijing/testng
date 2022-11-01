package com.xzj.mapper;

import com.xzj.LFTApplication_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(classes = LFTApplication_2.class)
public class TestCompanyDataMapper extends AbstractTestNGSpringContextTests {
    @Autowired
    CompanyDataMapper companyDataMapper;

    @Test
    public void testQueryCompanyAll(){

    }
}
